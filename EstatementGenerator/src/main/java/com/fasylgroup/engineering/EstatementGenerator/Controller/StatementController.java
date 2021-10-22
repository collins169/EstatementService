package com.fasylgroup.engineering.EstatementGenerator.Controller;

import com.fasylgroup.engineering.EstatementGenerator.Configuration.DBConfiguration;
import com.fasylgroup.engineering.EstatementGenerator.Model.SttbScheduledStatements;
import com.fasylgroup.engineering.EstatementGenerator.Repository.CustomRepository;
import com.fasylgroup.engineering.EstatementGenerator.Repository.SttbScheduledStatementsRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class StatementController {

    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
    public static final int SUNDAY = 7;

    private Logger logger = LoggerFactory.getLogger(StatementController.class);
    @Autowired
    private DBConfiguration dbConfiguration;
    @Autowired
    private CustomRepository customRepository;
    @Autowired
    private SttbScheduledStatementsRepository statementsRepository;
    @Autowired
    private ProcessorController processorController;

    @Value("${STATEMENTS_START_TIME}")
    private String TimeToSendStatements;
    @Value("${STATEMENTS_TO_TUN}")
    private String TimeToRunStatements;

    @Async
    public void ScheduleDailyStatement() {
        try {
            logger.info("==================== Daily Statement ====================");
            logger.info("TimeToSendStatements: {}", TimeToSendStatements);
            String[] TimeToSend = TimeToSendStatements.split("-");
            logger.info("Time: {}", Calendar.getInstance().getTime());
            int SetStartDay = Integer.parseInt(TimeToSend[0]);
            int SetEndDay = Integer.parseInt(TimeToSend[1]);

            DateTime CurrDay = new DateTime(Calendar.getInstance().getTime());
            DateTime StartDay = new DateTime(CurrDay.getYear(), CurrDay.getMonthOfYear(), SetStartDay, 0, 0);
            DateTime EndDay = new DateTime(CurrDay.getYear(), CurrDay.getMonthOfYear(), SetEndDay, 0, 0);
            logger.info("Current Day: {}", new SimpleDateFormat("dd-MMM-yyyy").format(CurrDay.toDate()));
            logger.info("Set Start Day: {}", new SimpleDateFormat("dd-MMM-yyyy").format(StartDay.toDate()));
            logger.info("Set End Day: {}", new SimpleDateFormat("dd-MMM-yyyy").format(EndDay.toDate()));

            if (CurrDay.isAfter(StartDay) && CurrDay.isBefore(EndDay)) {
                if (TimeToRunStatements.toUpperCase().contains("D")) {
                    logger.info("Let run query for Daily statement with this parameters");
                    Date calTransDate = new DateTime().minusDays(1).toDate();
                    Date cobTransDate = new DateTime().toDate();
                    logger.info("StartDate: {}", new SimpleDateFormat("dd-MMM-yyyy").format(calTransDate));
                    logger.info("EndDate: {}", new SimpleDateFormat("dd-MMM-yyyy").format(cobTransDate));
                    if (new DateTime(calTransDate).getDayOfWeek() != DateTimeConstants.SATURDAY && new DateTime(calTransDate).getDayOfWeek() != DateTimeConstants.SUNDAY) {
                        cobTransDate = calTransDate;
                    } else {
                        cobTransDate = customRepository.GetTodayDate();
                    }
//                List<SttbScheduledStatements> sttbScheduledStatements = customRepository.GetDailyStatements(new DateTime(cobTransDate.getTime()).minusDays(1).toDate(), cobTransDate);
//                customRepository.InsertRecords(sttbScheduledStatements, "DAILY");
                    customRepository.GetStatements(new DateTime(cobTransDate.getTime()).minusDays(1).toDate(), cobTransDate, "DAILY");
                }
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
        }
    }

    @Async
    public void ScheduleWeeklyStatement() {
        try {
            logger.info("==================== Weekly Statement ====================");
            logger.info("TimeToSendStatements: {}", TimeToSendStatements);
            String[] TimeToSend = TimeToSendStatements.split("-");
            logger.info("Time: {}", Calendar.getInstance().getTime());
            int SetStartDay = Integer.parseInt(TimeToSend[0]);
            int SetEndDay = Integer.parseInt(TimeToSend[1]);

            DateTime CurrDay = new DateTime(Calendar.getInstance().getTime());
            DateTime StartDay = new DateTime(CurrDay.getYear(), CurrDay.getMonthOfYear(), SetStartDay, 0, 0);
            DateTime EndDay = new DateTime(CurrDay.getYear(), CurrDay.getMonthOfYear(), SetEndDay, 0, 0);
            logger.info("Current Day: {}", new SimpleDateFormat("dd-MMM-yyyy").format(CurrDay.toDate()));
            logger.info("Set Start Day: {}", new SimpleDateFormat("dd-MMM-yyyy").format(StartDay.toDate()));
            logger.info("Set End Day: {}", new SimpleDateFormat("dd-MMM-yyyy").format(EndDay.toDate()));

            if (CurrDay.isAfter(StartDay) && CurrDay.isBefore(EndDay)) {
                if (TimeToRunStatements.toUpperCase().contains("W") && CurrDay.getDayOfWeek() == DateTimeConstants.SATURDAY) {
                    logger.info("Let run query for weekly statement with this parameters");
                    Date cobTransStartDate = new DateTime().minusDays(5).toDate();
                    Date cobTransEndDate = new DateTime().minusDays(1).toDate();
                    logger.info("StartDate: {}", new SimpleDateFormat("dd-MMM-yyyy").format(cobTransStartDate));
                    logger.info("EndDate: {}", new SimpleDateFormat("dd-MMM-yyyy").format(cobTransEndDate));

//                List<SttbScheduledStatements> sttbScheduledStatements = customRepository.GetWeeklyStatements(cobTransStartDate, cobTransEndDate);
//                customRepository.InsertRecords(sttbScheduledStatements, "WEEKLY");
                    customRepository.GetStatements(cobTransStartDate, cobTransEndDate, "WEEKLY");
                    Thread.sleep(1000);
                }
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
        }
    }

    @Async
    public void ScheduleMonthlyStatement() {
        try {
            logger.info("==================== Monthly Statement ====================");
            logger.info("TimeToSendStatements: {}", TimeToSendStatements);
            String[] TimeToSend = TimeToSendStatements.split("-");
            logger.info("Time: {}", Calendar.getInstance().getTime());
            int SetStartDay = Integer.parseInt(TimeToSend[0]);
            int SetEndDay = Integer.parseInt(TimeToSend[1]);

            DateTime CurrDay = new DateTime(Calendar.getInstance().getTime());
            DateTime StartDay = new DateTime(CurrDay.getYear(), CurrDay.getMonthOfYear(), SetStartDay, 0, 0);
            DateTime EndDay = new DateTime(CurrDay.getYear(), CurrDay.getMonthOfYear(), SetEndDay, 0, 0);
            logger.info("Current Day: {}", new SimpleDateFormat("dd-MMM-yyyy").format(CurrDay.toDate()));
            logger.info("Set Start Day: {}", new SimpleDateFormat("dd-MMM-yyyy").format(StartDay.toDate()));
            logger.info("Set End Day: {}", new SimpleDateFormat("dd-MMM-yyyy").format(EndDay.toDate()));

            if (CurrDay.isAfter(StartDay) && CurrDay.isBefore(EndDay)) {
                if (TimeToRunStatements.toUpperCase().contains("M") && (CurrDay.getDayOfWeek() >= 8 || CurrDay.getDayOfWeek() <= 8)) {
                    logger.info("Let run query for monthly statement with this parameters");
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.MONTH, -1);
                    calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
                    Date cobTransStartDate = calendar.getTime();
                    ;
                    calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                    Date cobTransEndDate = calendar.getTime();
                    logger.info("StartDate: {}", new SimpleDateFormat("dd-MMM-yyyy").format(cobTransStartDate));
                    logger.info("EndDate: {}", new SimpleDateFormat("dd-MMM-yyyy").format(cobTransEndDate));

//                List<SttbScheduledStatements> sttbScheduledStatements = customRepository.GetMonthlyStatements(cobTransStartDate, cobTransEndDate);
//                customRepository.InsertRecords(sttbScheduledStatements, "MONTHLY");
                    customRepository.GetStatements(cobTransStartDate, cobTransEndDate, "MONTHLY");
                    Thread.sleep(1000);
                }
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
        }
    }

    @Async
    public void GenerateDailyPdf(){
        logger.info("================== Generating Daily PDF ==================");
        List<SttbScheduledStatements> sttbScheduledStatements = statementsRepository.findAllByStatusAndStmntType("UNPROCESSED", "DAILY");
        logger.info("Total Daily PDF to Generate: {}", sttbScheduledStatements.size());
        if(sttbScheduledStatements.size() > 0){
            sttbScheduledStatements.parallelStream().forEach(statement -> {
                String pass = processorController.GeneratePassword(statement.getAcNo(), statement.getCustNo());
                if(pass == null){
                    statement.setStatus("FAILED");
                    statementsRepository.save(statement);
                }else{
                    statement.setStmtPass(pass);
                    processorController.CreateStatement(statement);
                }
            });
        }
    }

    @Async
    public void GenerateWeeklyPdf(){
        logger.info("================== Generating Weekly PDF ==================");
        List<SttbScheduledStatements> sttbScheduledStatements = statementsRepository.findAllByStatusAndStmntType("UNPROCESSED", "WEEKLY");
        logger.info("Total Weekly PDF to Generate: {}", sttbScheduledStatements.size());
        if(sttbScheduledStatements.size() > 0){
            sttbScheduledStatements.parallelStream().forEach(statement -> {
                String pass = processorController.GeneratePassword(statement.getAcNo(), statement.getCustNo());
                if(pass == null){
                    statement.setStatus("FAILED");
                    statementsRepository.save(statement);
                }else{
                    statement.setStmtPass(pass);
                    logger.info(statement.toString());
                    processorController.CreateStatement(statement);
                }
            });
        }
    }

    @Async
    public void GenerateMonthlyPdf(){
        logger.info("================== Generating Monthly PDF ==================");
        List<SttbScheduledStatements> sttbScheduledStatements = statementsRepository.findAllByStatusAndStmntType("UNPROCESSED", "MONTHLY");
        logger.info("Total Monthly PDF to Generate: {}", sttbScheduledStatements.size());
        if(sttbScheduledStatements.size() > 0){
            sttbScheduledStatements.parallelStream().forEach(statement -> {
                String pass = processorController.GeneratePassword(statement.getAcNo(), statement.getCustNo());
                logger.info("Password: {}", pass);
                if(pass == null){
                    statement.setStatus("FAILED");
                    statementsRepository.save(statement);
                }else{
                    statement.setStmtPass(pass);
                    logger.info(statement.toString());
                    processorController.CreateStatement(statement);
                }
            });
        }
    }
}
