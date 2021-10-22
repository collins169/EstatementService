package com.fasylgroup.engineering.EstatementGenerator.Repository;

import com.fasterxml.uuid.Generators;
import com.fasylgroup.engineering.EstatementGenerator.Configuration.DBConfiguration;
import com.fasylgroup.engineering.EstatementGenerator.Constants;
import com.fasylgroup.engineering.EstatementGenerator.Model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class CustomRepository {
    @Autowired
    private DBConfiguration dbConfiguration;
    private Logger logger = LoggerFactory.getLogger(CustomRepository.class);
    @Value("${TABLE_NAME}")
    private String tableName;
    @Value("${STATEMENT_PROCEDURE}")
    private String procedureName;
    @Value("${BULK_BATCH_SIZE}")
    private String batchSize;

    public Date GetTodayDate(){
        Date today = new Date();
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select today from sttm_dates where branch_code = '000'");
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                today = set.getDate(1);
            }
            preparedStatement.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error("Exception in GetTodayDate: {}",ex.getMessage());
        }
        return today;
    }

    public String GetCustomerNo(String custAcNo){
        String custNo = "";
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CUST_NO FROM STTM_CUST_ACCOUNT WHERE CUST_AC_NO = ?");
            preparedStatement.setString(1, custAcNo);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                custNo = set.getString(1);
            }
            preparedStatement.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error("Exception in GetCustomerNo: {}",ex.getMessage());
        }
        return custNo;
    }

    public List<AccountInfo> GetAccounts(String custAcNo){
        List<AccountInfo> accountInfos = new ArrayList<>();
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("select cust_ac_no , account_class from sttm_cust_account where \n" +
                    "cust_no = (select cust_no from sttm_cust_account where cust_ac_no = ? AND RECORD_STAT = 'O') \n" +
                    "order by ac_open_date, account_class");
            stmt.setString(1, custAcNo);
            ResultSet set = stmt.executeQuery();
            while(set.next()){
                AccountInfo info = new AccountInfo();
                info.setCustAcNo(set.getString("cust_ac_no"));
                info.setAccountClass(set.getString("account_class"));
                accountInfos.add(info);
            }
            stmt.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error("Exception in GetAccounts: {}", ex.getMessage());
        }
        return accountInfos;
    }

    public String GetAccount(String custNo){
        String account = "";
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM (select cust_ac_no , account_class from sttm_cust_account where \n" +
                    "cust_no = ? AND RECORD_STAT = 'O' \n" +
                    "order by ac_open_date ASC, account_class ASC ) WHERE ROWNUM = 1");
            stmt.setString(1, custNo);
            ResultSet set = stmt.executeQuery();
            while(set.next()){
                account = set.getString("cust_ac_no");
            }
            stmt.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error("Exception in GetAccounts: {}", ex.getMessage());
        }
        return account;
    }

    public boolean checkGuid(String guid){
        String sql = "SELECT TO_NUMBER(COUNT(*)) as COUNT FROM "+tableName+" WHERE GUID = ?";
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, guid);
            ResultSet set = stmt.executeQuery();
            while(set.next()){
                int count = set.getInt("COUNT");
//                logger.info("TOTAL COUNT FOR GUID {} = {}", guid, count);
                if( count > 0){
                    return true;
                }
            }
            stmt.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
            return false;
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return false;
    }

    public List<SttbScheduledStatements> GetDailyStatements(Date startDate, Date endDate){
        List<SttbScheduledStatements> sttbScheduledStatements = new ArrayList<>();
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT DISTINCT SYS_GUID() || '' || ROWNUM ''|TO_CHAR(SYSDATE, '') as GUID, AC_NO, C.EMAIL AS EMAIL FROM CMTM_ACCOUNTS B, CMVW_REG_CUSTOMERS C WHERE \n" +
                    "DAILY_STMNT=1 AND B.AUTH_STAT=1 AND C.CUSTOMER_NO = B.CUST_ID AND C.EMAIL IS NOT NULL AND AC_NO NOT IN \n" +
                    "(SELECT AC_NO FROM "+tableName+" WHERE STMNT_TYPE='DAILY' AND TO_CHAR(SCHEDULE_STAMP, 'DD-MON-YYYY') = ?)");
            stmt.setString(1, new SimpleDateFormat("dd-MMM-yyyy").format(new Date()).toUpperCase());
            ResultSet set = stmt.executeQuery();
            while (set.next()){
                SttbScheduledStatements statement = new SttbScheduledStatements();
//                UUID Guid = Generators.randomBasedGenerator().generate();
                statement.setAcNo(set.getString("AC_NO"));
                statement.setEmail(set.getString("EMAIL"));
                statement.setStatus("UNPROCESSED");
                statement.setStmntType("DAILY");
                statement.setStartDate(startDate);
                statement.setEndDate(endDate);
                statement.setGuid(set.getString("GUID"));
                statement.setScheduleStamp(new Date());
                sttbScheduledStatements.add(statement);
            }
            stmt.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return sttbScheduledStatements;
    }


    public List<SttbScheduledStatements> GetWeeklyStatements(Date startDate, Date endDate){
        List<SttbScheduledStatements> sttbScheduledStatements = new ArrayList<>();
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT DISTINCT SYS_GUID() || '' || ROWNUM as GUID, AC_NO, C.E_MAIL AS EMAIL FROM CMTM_ACCOUNTS B,CMVW_REG_CUSTOMERS C WHERE \n" +
                    "WEEKLY_STMNT=1 AND B.AUTH_STAT=1 AND C.CUSTOMER_NO = B.CUST_ID AND C.EMAIL IS NOT NULL AND AC_NO NOT IN \n" +
                    "(SELECT AC_NO FROM "+tableName+" WHERE STMNT_TYPE='WEEKLY' AND TO_CHAR(SCHEDULE_STAMP, 'DD-MON-YYYY') = ?)");
            stmt.setString(1, new SimpleDateFormat("dd-MMM-yyyy").format(new Date()).toUpperCase());
            ResultSet set = stmt.executeQuery();
            while (set.next()){
                SttbScheduledStatements statement = new SttbScheduledStatements();
//                UUID Guid = Generators.randomBasedGenerator().generate();
                statement.setAcNo(set.getString("AC_NO"));
                statement.setEmail(set.getString("EMAIL"));
                statement.setStatus("UNPROCESSED");
                statement.setStmntType("WEEKLY");
                statement.setStartDate(startDate);
                statement.setEndDate(endDate);
                statement.setGuid(set.getString("GUID"));
                statement.setScheduleStamp(new Date());
                sttbScheduledStatements.add(statement);
            }
            stmt.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return sttbScheduledStatements;
    }

    public List<SttbScheduledStatements> GetMonthlyStatements(Date startDate, Date endDate){
        List<SttbScheduledStatements> sttbScheduledStatements = new ArrayList<>();
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            String sql = "SELECT DISTINCT SYS_GUID() || '' || ROWNUM AS GUID, AC_NO, C.E_MAIL AS EMAIL FROM CMTM_ACCOUNTS B,CMVW_REG_CUSTOMERS C WHERE\n" +
                    "MONTHLY_STMNT=1 AND B.AUTH_STAT=1 AND C.CUSTOMER_NO = B.CUST_ID AND C.EMAIL IS NOT NULL AND AC_NO NOT IN\n" +
                    "(SELECT AC_NO FROM "+tableName+" WHERE STMNT_TYPE='MONTHLY' AND TO_CHAR(SCHEDULE_STAMP, 'MON-YYYY') = ?)";
//            logger.info(sql);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, new SimpleDateFormat("MMM-yyyy").format(new Date()).toUpperCase());
            ResultSet set = stmt.executeQuery();
            while (set.next()){
                SttbScheduledStatements statement = new SttbScheduledStatements();
//                UUID Guid = Generators.randomBasedGenerator().generate();
                statement.setAcNo(set.getString("AC_NO"));
                statement.setEmail(set.getString("EMAIL"));
                statement.setStatus("UNPROCESSED");
                statement.setStmntType("MONTHLY");
                statement.setStartDate(startDate);
                statement.setEndDate(endDate);
                statement.setGuid(set.getString("GUID"));
                statement.setScheduleStamp(new Date());
                sttbScheduledStatements.add(statement);
            }
            stmt.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return sttbScheduledStatements;
    }


    public void GetStatements(Date startDate, Date endDate, String type){
        String errCode = "";
        String errMsg = "";
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            CallableStatement stmt = connection.prepareCall("{ call "+ procedureName +"(?, ?, ?, ?, ?) }");
            stmt.setDate(1, new java.sql.Date(startDate.getTime()));
            stmt.setDate(2, new java.sql.Date(endDate.getTime()));
            stmt.setString(3, type);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.registerOutParameter(5, Types.VARCHAR);
            stmt.executeUpdate();
            errCode = stmt.getString(4);
            errMsg = stmt.getString(5);
            logger.info("PR_GET_ALL_PENDING_STATEMENTS returned >>>>> ErrCode: {} || ErrMsg: {}", errCode, errMsg);
            stmt.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }

    @Async
    public void InsertRecords(List<SttbScheduledStatements> sttbScheduledStatements, String type){
        logger.info("About to insert into STTB_SCHEDULED_STATMENTS Total record: {} For {} statment", sttbScheduledStatements.size(), type);
        String sql = "INSERT INTO "+tableName+" (GUID, AC_NO, START_DATE, END_DATE, STMNT_TYPE, STATUS, SCHEDULE_STAMP, EMAIL) \n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            AtomicInteger count = new AtomicInteger();
            sttbScheduledStatements.parallelStream().forEach(statement -> {
                try {
                    stmt.setString(1, statement.getGuid());
                    stmt.setString(2, statement.getAcNo());
                    stmt.setDate(3, new java.sql.Date(statement.getStartDate().getTime()));
                    stmt.setDate(4, new java.sql.Date(statement.getEndDate().getTime()));
                    stmt.setString(5, statement.getStmntType());
                    stmt.setString(6, statement.getStatus());
                    stmt.setTimestamp(7, new java.sql.Timestamp(statement.getScheduleStamp().getTime()));
                    stmt.setString(8, statement.getEmail());
                    stmt.addBatch();
                    if(count.incrementAndGet() % Integer.parseInt(batchSize) == 0) {
                        stmt.executeBatch();
                        connection.commit();
                    }
                }catch (Exception exception){
                    logger.error("Failed Processing Batch");
                    logger.error(exception.toString(), exception);
                }
            });
            stmt.executeBatch(); // insert remaining records
            connection.commit();
            stmt.close();
            if (!connection.isClosed()) {
                connection.close();
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }

    public List<StvwTransaction> GetTransactions(String startDate, String endDate, String acNo){
        List<StvwTransaction> transactions = new ArrayList<>();
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT a.* FROM stvw_transactions2 a WHERE a.TRN_DT BETWEEN ? AND ? AND a.AC_NO = ? ORDER BY a.AC_ENTRY_SR_NO ASC");
            stmt.setString(1, startDate);
            stmt.setString(2, endDate);
            stmt.setString(3, acNo);
            ResultSet set = stmt.executeQuery();
            while (set.next()){
                StvwTransaction transaction = new StvwTransaction();
                transaction.setAcCcy(set.getString("AC_CCY"));
                transaction.setAcDesc(set.getString("AC_DESC"));
                transaction.setAcEntrySrNo(set.getLong("AC_ENTRY_SR_NO"));
                transaction.setAcNo(set.getString("AC_NO"));
                transaction.setAcyOpeningBal(set.getDouble("ACY_OPENING_BAL"));
                transaction.setAmount(set.getDouble("AMOUNT"));
                transaction.setCredit(set.getString("CREDIT"));
                transaction.setDebit(set.getString("DEBIT"));
                transaction.setDescription(set.getString("DESCRIPTION"));
                transaction.setDrCrInd(set.getString("DRCR_IND"));
                transaction.setFcyAmount(set.getDouble("FCY_AMOUNT"));
                transaction.setInstrumentCode(set.getString("INSTRUMENT_CODE"));
                transaction.setLcyAmount(set.getDouble("LCY_AMOUNT"));
                transaction.setNarration(set.getString("NARRATION"));
                transaction.setRunningBal(set.getDouble("RUNNINGBAL"));
                transaction.setTrnDt(set.getDate("TRN_DT"));
                transaction.setValueDt(set.getDate("VALUE_DT"));
                transaction.setTrnRefNo(set.getString("TRN_REF_NO"));
                transactions.add(transaction);
            }
            stmt.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error("Exception in GetTransactions: {}", ex.getMessage());
        }
        return transactions;
    }
    
    public List<CustomerInformation> GetCustomerInformation(String CustId, Date startDate, Date endDate){
        logger.info("=================== Getting Customer Information ===================");
        List<CustomerInformation> customerInformations = new ArrayList<>();
        int count = 0;
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT CUST_AC_NO FROM STVW_CUST_ACCOUNTS WHERE CUST_NO = ?");
            stmt.setString(1, CustId);
            ResultSet set = stmt.executeQuery();
            while(set.next()){
//                String sql = MessageFormat.format(Constants.GetInformation, new SimpleDateFormat("dd-MMM-yyyy").format(startDate),
//                        new SimpleDateFormat("dd-MMM-yyyy").format(endDate), set.getString("CUST_AC_NO"));
                String sql = Constants.GetInformation;
                sql = sql.replace("{0}", new SimpleDateFormat("dd-MMM-yyyy").format(startDate).toUpperCase());
                sql = sql.replace("{1}", new SimpleDateFormat("dd-MMM-yyyy").format(endDate).toUpperCase());
                sql = sql.replace("{2}", set.getString("CUST_AC_NO"));
//                logger.info("\n {} \n",sql);
                PreparedStatement stmt2 = connection.prepareStatement(sql);
                ResultSet set1 = stmt2.executeQuery();
                while (set1.next()){
                    CustomerInformation information = new CustomerInformation();
                    count++;
                    information.setPosition(count);
                    information.setAcyOpeningBal(set1.getDouble("acy_opening_balance"));
                    information.setAcyAvlbal(set1.getDouble("closing_balance"));
                    information.setCustAcNo(set.getString("CUST_AC_NO"));
                    information.setDescription(set1.getString("description"));
                    information.setCustomerName(set1.getString("ac_desc"));
                    information.setAcyTodayToverCr(set1.getDouble("CR_TOT"));
                    information.setAcyTodayToverDr(set1.getDouble("DR_TOT"));
                    information.setAddress2(set1.getString("address2"));
                    information.setBranchAddr1(set1.getString("branch_addr1"));
                    information.setBranchCode(set1.getString("branch_code"));
                    information.setBranchName(set1.getString("branch_name"));
                    information.setCcy(set1.getString("ccy"));
                    information.setCustNo(set1.getString("cust_no"));
                    customerInformations.add(information);
                }
                set1.close();
                stmt2.close();
            }
            set.close();
            stmt.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error("Exception in GetCustomerInformation: {}", ex.getMessage());
        }
        return customerInformations;
    }

    public List<CustomerInformation> GetCustomerInformation(List<AllCustomerAccount> customerAccounts, Date startDate, Date endDate){
        logger.info("=================== Getting Customer Information ===================");
        List<CustomerInformation> customerInformations = new ArrayList<>();
        int count = 0;
        try{
            if(customerAccounts.size() > 0) {
                Connection connection = dbConfiguration.dataSource().getConnection();
                for (AllCustomerAccount customerAccount : customerAccounts.stream().sorted( Comparator.comparingInt(AllCustomerAccount::getPosition)).collect(Collectors.toList())) {
                    String sql = Constants.GetInformation;
                    sql = sql.replace("{0}", new SimpleDateFormat("dd-MMM-yyyy").format(startDate).toUpperCase());
                    sql = sql.replace("{1}", new SimpleDateFormat("dd-MMM-yyyy").format(endDate).toUpperCase());
                    sql = sql.replace("{2}", customerAccount.getCustAcNo());
//                logger.info("\n {} \n",sql);
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet set = stmt.executeQuery();
                    while (set.next()) {
                        CustomerInformation information = new CustomerInformation();
                        count++;
                        information.setPosition(count);
                        information.setAcyOpeningBal(set.getDouble("acy_opening_balance"));
                        information.setAcyAvlbal(set.getDouble("closing_balance"));
                        information.setCustAcNo(customerAccount.getCustAcNo());
                        information.setDescription(set.getString("description"));
                        information.setCustomerName(set.getString("ac_desc"));
                        information.setAcyTodayToverCr(set.getDouble("CR_TOT"));
                        information.setAcyTodayToverDr(set.getDouble("DR_TOT"));
                        information.setAddress2(set.getString("address2"));
                        information.setBranchAddr1(set.getString("branch_addr1"));
                        information.setBranchCode(set.getString("branch_code"));
                        information.setBranchName(set.getString("branch_name"));
                        information.setCcy(set.getString("ccy"));
                        information.setCustNo(set.getString("cust_no"));
                        customerInformations.add(information);
                    }
                    set.close();
                    stmt.close();
                }
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        }catch (Exception ex){
            logger.error("Exception in GetCustomerInformation: {}", ex.getMessage());
        }
        return customerInformations;
    }

    public List<AllCustomerAccount> GetAllCustomerAccount(String CustId, Date startDate, Date endDate){
        List<AllCustomerAccount> allCustomerAccounts = new ArrayList<>();
        int count = 0;
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("select B.CUST_AC_NO, NVL((SELECT SUM(DECODE(AC_CCY, 'GHS', DECODE (drcr_ind, 'C', lcy_amount, -lcy_amount),\n" +
                    "DECODE (drcr_ind, 'C', fcy_amount, -fcy_amount))) FROM ACVW_ALL_AC_ENTRIES\n" +
                    "WHERE AC_NO = B.CUST_AC_NO AND TRN_DT < ? GROUP BY AC_NO ), 0) AS ACY_AVL_BAL, B.AC_DESC, C.CCY_NAME, TRIM(D.DESCRIPTION) as DESCRIPTION\n" +
                    "FROM STTM_CUST_ACCOUNT B, CYTM_CCY_DEFN C, STTM_ACCOUNT_CLASS D WHERE C.CCY_CODE = B.CCY AND\n" +
                    "D.ACCOUNT_CLASS = B.ACCOUNT_CLASS AND B.CUST_NO = ? and B.ACCOUNT_CLASS not in\n" +
                    "(select account_class from altm_denied_account_classes) and b.record_stat = 'O' ORDER BY B.AC_OPEN_DATE ASC");
            stmt.setString(1, new SimpleDateFormat("dd-MMM-yyyy").format(startDate).toUpperCase());
            stmt.setString(2, CustId);
            ResultSet set = stmt.executeQuery();
            while (set.next()){
                count++;
                AllCustomerAccount customerAccount = new AllCustomerAccount();
                customerAccount.setPosition(count);
                customerAccount.setCustAcNo(set.getString("CUST_AC_NO"));
                customerAccount.setAcyAvlBal(set.getDouble("ACY_AVL_BAL"));
                customerAccount.setAcDesc(set.getString("AC_DESC"));
                customerAccount.setCcyName(set.getString("CCY_NAME"));
                customerAccount.setDescription(set.getString("DESCRIPTION"));
                allCustomerAccounts.add(customerAccount);
            }
            set.close();
            stmt.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error("Exception in GetAllCustomerAccount: {} ", ex.getMessage());
        }
        return allCustomerAccounts;
    }

    public void UpdateLog(SttbScheduledStatements statement){
        try{
            Connection conn = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE "+tableName+" SET PDF_PATH = ?, STATUS = ?, SCHEDULE_STAMP = ? WHERE GUID = ? AND AC_NO = ?");
            stmt.setString(1, statement.getPdfPath());
            stmt.setString(2, statement.getStatus());
            stmt.setDate(3, new java.sql.Date(statement.getScheduleStamp().getTime()));
            stmt.setString(4, statement.getGuid());
            stmt.setString(5, statement.getAcNo());
            int result = stmt.executeUpdate();
            logger.info("Updated record: {}", statement.toString());
            stmt.close();
            conn.commit();
            if(!conn.isClosed()){
                conn.close();
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }

    }
}
