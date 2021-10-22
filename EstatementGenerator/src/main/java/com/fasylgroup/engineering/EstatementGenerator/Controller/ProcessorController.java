package com.fasylgroup.engineering.EstatementGenerator.Controller;

import com.fasylgroup.engineering.EstatementGenerator.Configuration.DBConfiguration;
import com.fasylgroup.engineering.EstatementGenerator.Model.*;
import com.fasylgroup.engineering.EstatementGenerator.Repository.CustomRepository;
import com.fasylgroup.engineering.EstatementGenerator.Repository.SttbScheduledStatementsRepository;
import com.fasylgroup.engineering.EstatementGenerator.Repository.StvwTransactionRepository;
import com.fasylgroup.engineering.EstatementGenerator.Service.PDFService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ProcessorController {
    private Logger logger = LoggerFactory.getLogger(StatementController.class);
    @Autowired
    private DBConfiguration dbConfiguration;
    @Autowired
    private CustomRepository customRepository;
    @Autowired
    private SttbScheduledStatementsRepository statementsRepository;
    @Autowired
    private StvwTransactionRepository transactionRepository;
    @Autowired
    private PDFService pdfService;

    @Value("${STATEMENTS_START_TIME}")
    private String TimeToSendStatements;
    @Value("${STATEMENTS_TO_TUN}")
    private String TimeToRunStatements;

    public Object[] GetStatementsForAllAccounts(String custId, Date startDate, Date endDate){
        logger.info("==================== GetStatementsForAllAccounts ========================");
        TransactionStatistics statistics = new TransactionStatistics();
        List<TransactionHistory> histories = new ArrayList<>();
        List<StvwTransaction> transactions = new ArrayList<>();
        Object[] result = new Object[4];
        try{
            List<AllCustomerAccount> customerAccounts = customRepository.GetAllCustomerAccount(custId, startDate, endDate);
            logger.info("GetStatementsForAllAccounts size: {}", customerAccounts.size());
            if (customerAccounts.size() > 0 ){
                for (AllCustomerAccount acount: customerAccounts) {
                    TransactionHistory history = new TransactionHistory();
                    try {
                        transactions = transactionRepository.getAllTransactionByDateAndAcNo(new SimpleDateFormat("dd-MMM-yyyy").format(startDate),
                                new SimpleDateFormat("dd-MMM-yyyy").format(endDate), acount.getCustAcNo());
                    }catch (Exception ex){
                        logger.error(ex.getMessage());
                        transactions = customRepository.GetTransactions(new SimpleDateFormat("dd-MMM-yyyy").format(startDate),
                                new SimpleDateFormat("dd-MMM-yyyy").format(endDate), acount.getCustAcNo());
                    }
                    logger.info("Total Transactions: {}", transactions.size());
                    statistics.setTotalNumOfTransaction(statistics.getTotalNumOfTransaction()+transactions.size());
                    statistics.setTotalCredits(statistics.getTotalCredits() + transactions.parallelStream()
                            .filter(trans -> trans.getDrCrInd().equalsIgnoreCase("D"))
                            .mapToDouble(StvwTransaction::getAmount).sum());
                    statistics.setTotalDebits(statistics.getTotalDebits() + transactions.parallelStream()
                            .filter(trans -> trans.getDrCrInd().equalsIgnoreCase("C"))
                            .mapToDouble(StvwTransaction::getAmount).sum());
                    statistics.setTotalAtmTransaction( statistics.getTotalAtmTransaction() + new Long(transactions.parallelStream()
                            .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZATM"))
                            .count()).intValue());
                    statistics.setTotalAtmCredits( statistics.getTotalAtmCredits() + transactions.parallelStream()
                            .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZATM") && trans.getDrCrInd().equalsIgnoreCase("C"))
                            .mapToDouble(StvwTransaction::getAmount).sum());
                    statistics.setTotalAtmDebits(statistics.getTotalAtmDebits() + transactions.parallelStream()
                            .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZATM") && trans.getDrCrInd().equalsIgnoreCase("D"))
                            .mapToDouble(StvwTransaction::getAmount).sum());
                    statistics.setTotalPosTransaction(statistics.getTotalPosTransaction() + new Long(transactions.parallelStream()
                            .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZPOS"))
                            .count()).intValue());
                    statistics.setTotalPosCredits(statistics.getTotalPosCredits() + transactions.parallelStream()
                            .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZPOS") && trans.getDrCrInd().equalsIgnoreCase("C"))
                            .mapToDouble(StvwTransaction::getAmount).sum());
                    statistics.setTotalPosDebits(statistics.getTotalPosDebits() + transactions.parallelStream()
                            .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZPOS") && trans.getDrCrInd().equalsIgnoreCase("D"))
                            .mapToDouble(StvwTransaction::getAmount).sum());
                    statistics.setOthersTotalTransaction(statistics.getOthersTotalTransaction() + new Long(transactions.parallelStream()
                            .filter(trans -> (!trans.getTrnRefNo().toUpperCase().contains("ZPOS") || !trans.getTrnRefNo().toUpperCase().contains("ZATM")))
                            .count()).intValue());
                    statistics.setOthersTotalCredits(statistics.getOthersTotalCredits() + transactions.parallelStream()
                            .filter(trans -> (!trans.getTrnRefNo().toUpperCase().contains("ZPOS") || !trans.getTrnRefNo().toUpperCase().contains("ZATM")) && trans.getDrCrInd().equalsIgnoreCase("C"))
                            .mapToDouble(StvwTransaction::getAmount).sum());
                    statistics.setOthersTotalDebits(statistics.getOthersTotalDebits() + transactions.parallelStream()
                            .filter(trans -> (!trans.getTrnRefNo().toUpperCase().contains("ZPOS") || !trans.getTrnRefNo().toUpperCase().contains("ZATM")) && trans.getDrCrInd().equalsIgnoreCase("D"))
                            .mapToDouble(StvwTransaction::getAmount).sum());
                    history.setAllCustomerAccount(acount);
                    history.setStvwTransactions(transactions);
                    histories.add(history);
                }
                result[0] = customerAccounts;
                result[1] = transactions;
                result[2] = histories;
                result[3] = statistics;
            }
        }catch (Exception ex){
            logger.info("Exception in GetStatementsForAllAccounts");
            logger.error(ex.toString(), ex);
        }
        return result;
    }

    public void CreateStatement(SttbScheduledStatements statements){
        logger.info("============= Generating Statement =============");
        if(statements.getCustNo() != null){
            try {
                logger.info("About getting GetStatementsForAllAccounts");
//                Object[] objects = GetStatementsForAllAccounts(custId, statements.getStartDate(), statements.getEndDate());
                List<AllCustomerAccount> customerAccounts = customRepository.GetAllCustomerAccount(statements.getCustNo(), statements.getStartDate(), statements.getEndDate());
                List<StvwTransaction> transactions = new ArrayList<>();
                List<TransactionHistory> histories = new ArrayList<>();
                TransactionStatistics statistics = new TransactionStatistics();
                logger.info("About getting customerInformations");
                List<CustomerInformation> customerInformations = customRepository.GetCustomerInformation(customerAccounts, statements.getStartDate(), statements.getEndDate());
                logger.info("Total customerInformations: {}", customerInformations.size());
                if (customerAccounts.size() > 0){
                    for (AllCustomerAccount acount: customerAccounts) {
                        TransactionHistory history = new TransactionHistory();
                        try {
                            transactions = transactionRepository.getAllTransactionByDateAndAcNo(new SimpleDateFormat("dd-MMM-yyyy").format(statements.getStartDate()),
                                    new SimpleDateFormat("dd-MMM-yyyy").format(statements.getEndDate()), acount.getCustAcNo());
                        }catch (Exception ex){
                            logger.error(ex.getMessage());
                            transactions = customRepository.GetTransactions(new SimpleDateFormat("dd-MMM-yyyy").format(statements.getStartDate()),
                                    new SimpleDateFormat("dd-MMM-yyyy").format(statements.getEndDate()), acount.getCustAcNo());
                        }
                        logger.info("Total Transactions: {}", transactions.size());
                        statistics.setTotalNumOfTransaction(statistics.getTotalNumOfTransaction() + transactions.size());
                        statistics.setTotalCredits(Double.parseDouble(new DecimalFormat("#.##").format(statistics.getTotalCredits() + transactions.parallelStream()
                                .filter(trans -> trans.getDrCrInd().equalsIgnoreCase("D"))
                                .mapToDouble(StvwTransaction::getAmount).sum())));
                        statistics.setTotalDebits(Double.parseDouble(new DecimalFormat("#.##").format(statistics.getTotalDebits() + transactions.parallelStream()
                                .filter(trans -> trans.getDrCrInd().equalsIgnoreCase("C"))
                                .mapToDouble(StvwTransaction::getAmount).sum())));
                        //ATM TRANSACTIONS
                        statistics.setTotalAtmTransaction(statistics.getTotalAtmTransaction() + new Long(transactions.parallelStream()
                                .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZATM"))
                                .count()).intValue());
                        statistics.setTotalAtmCredits(Double.parseDouble(new DecimalFormat("#.##").format(statistics.getTotalAtmCredits() + transactions.parallelStream()
                                .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZATM") && trans.getDrCrInd().equalsIgnoreCase("C"))
                                .mapToDouble(StvwTransaction::getAmount).sum())));
                        statistics.setTotalAtmDebits(Double.parseDouble(new DecimalFormat("#.##").format(statistics.getTotalAtmDebits() + transactions.parallelStream()
                                .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZATM") && trans.getDrCrInd().equalsIgnoreCase("D"))
                                .mapToDouble(StvwTransaction::getAmount).sum())));
                        //POS TRANSCTIONS
                        statistics.setTotalPosTransaction(statistics.getTotalPosTransaction() + new Long(transactions.parallelStream()
                                .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZPOS"))
                                .count()).intValue());
                        statistics.setTotalPosCredits(Double.parseDouble(new DecimalFormat("#.##").format(statistics.getTotalPosCredits() + transactions.parallelStream()
                                .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZPOS") && trans.getDrCrInd().equalsIgnoreCase("C"))
                                .mapToDouble(StvwTransaction::getAmount).sum())));
                        statistics.setTotalPosDebits(Double.parseDouble(new DecimalFormat("#.##").format(statistics.getTotalPosDebits() + transactions.parallelStream()
                                .filter(trans -> trans.getTrnRefNo().toUpperCase().contains("ZPOS") && trans.getDrCrInd().equalsIgnoreCase("D"))
                                .mapToDouble(StvwTransaction::getAmount).sum())));
                        //OTHER TRANSACTIONS
                        statistics.setOthersTotalTransaction(statistics.getOthersTotalTransaction() + new Long(transactions.parallelStream()
                                .filter(trans -> !(trans.getTrnRefNo().toUpperCase().contains("ZPOS") || trans.getTrnRefNo().toUpperCase().contains("ZATM")))
                                .count()).intValue());
                        statistics.setOthersTotalCredits(Double.parseDouble(new DecimalFormat("#.##").format(statistics.getOthersTotalCredits() + transactions.parallelStream()
                                .filter(trans -> !(trans.getTrnRefNo().toUpperCase().contains("ZPOS") || trans.getTrnRefNo().toUpperCase().contains("ZATM")) && trans.getDrCrInd().equalsIgnoreCase("C"))
                                .mapToDouble(StvwTransaction::getAmount).sum())));
                        statistics.setOthersTotalDebits(Double.parseDouble(new DecimalFormat("#.##").format(statistics.getOthersTotalDebits() + transactions.parallelStream()
                                .filter(trans -> !(trans.getTrnRefNo().toUpperCase().contains("ZPOS") || trans.getTrnRefNo().toUpperCase().contains("ZATM")) && trans.getDrCrInd().equalsIgnoreCase("D"))
                                .mapToDouble(StvwTransaction::getAmount).sum())));
                        history.setAllCustomerAccount(acount);
                        history.setStvwTransactions(transactions);
                        histories.add(history);
                    }

                    double totalAtm = ((double) statistics.getTotalAtmTransaction() / (double) statistics.getTotalNumOfTransaction()) * 100;
                    double totalPos = ((double) statistics.getTotalPosTransaction() / (double) statistics.getTotalNumOfTransaction()) * 100;
                    double others = ((double) statistics.getOthersTotalTransaction() / (double) statistics.getTotalNumOfTransaction()) * 100;
                    statistics.setTotalAtmPercent(Double.parseDouble((totalAtm > 0) ? new DecimalFormat("#.##").format(totalAtm) : "0.0"));
                    statistics.setTotalPosPercent(Double.parseDouble((totalPos > 0) ? new DecimalFormat("#.##").format(totalPos) : "0.0"));
                    statistics.setOthersTotalPercent(Double.parseDouble((others > 0) ? new DecimalFormat("#.##").format(others) : "0.0"));
                    logger.info("stvwTransactions : {}", transactions.toString());
                    logger.info("transactionHistories : {}", histories.toString());
                    logger.info("statistics : {}", statistics.toString());
                    StatementRequest request = new StatementRequest();
                    request.setCustId(statements.getCustNo());
                    request.setAllCustomerAccounts(customerAccounts);
                    request.setCustomerInformations(customerInformations);
                    request.setSttbScheduledStatements(statements);
                    request.setStvwTransactions(transactions);
                    request.setTransactionHistories(histories);
                    request.setTransactionStatistics(statistics);
                    logger.info("Calling PDF SERVICE");
                    pdfService.GeneratePDF(request);
                }else{
                    logger.info("No Customer Account Found");
                }
            }catch (Exception ex){
                logger.error("Exception in Create Statement");
                logger.error(ex.toString(), ex);
            }
        }
    }
    public String GeneratePassword(String acNo){
        logger.info("Generating password for account: {}", acNo);
        try {
            List<AccountInfo> infos = customRepository.GetAccounts(acNo);
            String[] classes = new String[]{"003", "006", "002", "010"};
            if(infos.size() == 0 ){
                return "";
            }
            for(AccountInfo info : infos) {
                if(Arrays.stream(classes).toString().contains(info.getAccountClass())){
                    return info.getCustAcNo();
                }
            };
        }catch (Exception ex){
            logger.info("Exception in Generate Password");
            logger.error(ex.toString(), ex);
            return "";
        }
        return acNo;
    }

    public  String GeneratePassword(String acNo, String CustId){
        logger.info("Generating password for account: {}", acNo);
        try {
            return customRepository.GetAccount(CustId);
        }catch (Exception ex){
            logger.info("Exception in Generate Password");
            logger.error(ex.toString(), ex);
            return "";
        }
    }
}
