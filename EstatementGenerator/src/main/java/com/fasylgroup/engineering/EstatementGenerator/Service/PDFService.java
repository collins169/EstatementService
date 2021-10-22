package com.fasylgroup.engineering.EstatementGenerator.Service;

import com.fasylgroup.engineering.EstatementGenerator.Model.StatementRequest;
import com.fasylgroup.engineering.EstatementGenerator.Model.SttbScheduledStatements;
import com.fasylgroup.engineering.EstatementGenerator.Repository.CustomRepository;
import com.fasylgroup.engineering.EstatementGenerator.Repository.SttbScheduledStatementsRepository;
import com.google.gson.Gson;
import fasylstatementlibrary.models.TransactionStatistics;
import net.sf.jni4net.Bridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class PDFService {
    private Logger logger = LoggerFactory.getLogger(PDFService.class);
    @Value("${LIB_PATH}")
    private String libPath;
    @Autowired
    private CustomRepository repository;
    @Autowired
    private SttbScheduledStatementsRepository statementsRepository;

//    @Async
    public void GeneratePDF(StatementRequest request) throws IOException {
        logger.info("LIB PATH: {}", libPath);
        Bridge.setVerbose(true);
        Bridge.init(new File(libPath + "/jni4net.n.w64.v40-0.8.8.0.dll"));
        File proxyAssembleFile = new File(libPath + "/FasylStatementLibrary.j4n.dll");
        Bridge.LoadAndRegisterAssemblyFrom(proxyAssembleFile);
        fasylstatementlibrary.StatementGenerator statementGenerator = new fasylstatementlibrary.StatementGenerator();
        fasylstatementlibrary.models.TransactionStatistics transactionStatistics = new TransactionStatistics();
        transactionStatistics.setOthersTotalTransaction(request.getTransactionStatistics().getOthersTotalTransaction());
        transactionStatistics.setOthersTotalCredits(request.getTransactionStatistics().getOthersTotalCredits());
        transactionStatistics.setOthersTotalDebits(request.getTransactionStatistics().getOthersTotalDebits());
        transactionStatistics.setTotalAtmCredits(request.getTransactionStatistics().getTotalAtmCredits());
        transactionStatistics.setTotalAtmDebits(request.getTransactionStatistics().getTotalAtmDebits());
        transactionStatistics.setTotalAtmTransaction(request.getTransactionStatistics().getTotalAtmTransaction());
        transactionStatistics.setTotalAtmPercent(request.getTransactionStatistics().getTotalAtmPercent());
        transactionStatistics.setTotalPosCredits(request.getTransactionStatistics().getTotalPosCredits());
        transactionStatistics.setTotalPosDebits(request.getTransactionStatistics().getTotalPosDebits());
        transactionStatistics.setTotalPosTransaction(request.getTransactionStatistics().getTotalPosTransaction());
        transactionStatistics.setTotalPosPercent(request.getTransactionStatistics().getTotalPosPercent());
        transactionStatistics.setTotalCredits(request.getTransactionStatistics().getTotalCredits());
        transactionStatistics.setTotalDebits(request.getTransactionStatistics().getTotalDebits());
        transactionStatistics.setTotalNumOfTransaction(request.getTransactionStatistics().getTotalNumOfTransaction());
        transactionStatistics.setOthersTotalPercent(request.getTransactionStatistics().getOthersTotalPercent());

        fasylstatementlibrary.models.SttbScheduledStatements statement = new fasylstatementlibrary.models.SttbScheduledStatements();
        statement.setacNo(request.getSttbScheduledStatements().getAcNo());
        statement.setemail(request.getSttbScheduledStatements().getEmail());
        statement.setguid(request.getSttbScheduledStatements().getGuid());
        statement.setstmntType(request.getSttbScheduledStatements().getStmntType());
        statement.setstatus(request.getSttbScheduledStatements().getStatus());
        statement.setstmtPass(request.getSttbScheduledStatements().getStmtPass());
        statement.setcustNo(request.getSttbScheduledStatements().getCustNo());
        String result = statementGenerator.GenerateStatement(request.getCustId(), new Gson().toJson(request.getCustomerInformations()), new Gson().toJson(request.getTransactionHistories()), transactionStatistics, statement);
        logger.info("PDF PATH: {}", result);
        String month = new SimpleDateFormat("MMM").format(new Date());
        String path = MessageFormat.format("C:\\eaes\\statementPdf\\{0}\\{1}\\{2}\\{3}.pdf", month, statement.getstmntType(), request.getCustId(), statement.getacNo());
        File file = new File(path);
        if (result == null || result.equals("")) {
            if(file.exists()){
                result = file.getAbsolutePath();
                cleanUpFiles(request.getSttbScheduledStatements(), request.getCustId());
            }
        }
//        Optional<SttbScheduledStatements> statementOptional = statementsRepository.findOneByGuidAndAcNo(request.getSttbScheduledStatements().getGuid(), request.getSttbScheduledStatements().getAcNo());
//        if(statementOptional.isPresent()){
        SttbScheduledStatements scheduledStatment = request.getSttbScheduledStatements();
        try {
            scheduledStatment.setScheduleStamp(new Date());
            scheduledStatment.setPdfPath(result);
            scheduledStatment.setStatus((result == null || result.equals("")) ? "FAILED" : "PENDING");
            repository.UpdateLog(scheduledStatment);
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            statementsRepository.save(scheduledStatment);
        }
//        }
//            repository.UpdateLog(scheduledStatment);
//        return CompletableFuture.completedFuture(result);
    }

    public void cleanUpFiles(SttbScheduledStatements statement, String custNo){
        try {
            String month = new SimpleDateFormat("MMM").format(new Date());
            File location = new File(MessageFormat.format("C:\\eaes\\statementPdf\\{0}\\{1}\\{2}", month, statement.getStmntType(), custNo));
            if(location.exists() && location.isDirectory()){
                File[] files = location.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (!file.getName().equals(statement.getAcNo()+".pdf")){
                            file.delete();
                        }
                    }
                }
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
        }
    }
}
