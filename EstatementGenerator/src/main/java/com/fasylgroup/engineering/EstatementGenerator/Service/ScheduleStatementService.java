package com.fasylgroup.engineering.EstatementGenerator.Service;

import com.fasylgroup.engineering.EstatementGenerator.Controller.ProcessorController;
import com.fasylgroup.engineering.EstatementGenerator.Controller.StatementController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleStatementService {

    Logger logger = LoggerFactory.getLogger(ScheduleStatementService.class);
    @Autowired
    private StatementController statementController;
    @Autowired
    private ProcessorController processorController;

//    @Scheduled(cron = "${DAILY_CRON_JOB}")
//    public void StartDailyStatement(){
//        statementController.ScheduleDailyStatement();
//    }
//
//    @Scheduled(cron = "${WEEKLY_CRON_JOB}")
//    public void StartWeeklyStatement(){
//        statementController.ScheduleWeeklyStatement();
//    }
//
//    @Scheduled(cron = "${MONTHLY_CRON_JOB}")
//    public void StartMonthlyStatement(){
//        statementController.ScheduleMonthlyStatement();
//    }

    @Scheduled(cron = "${GENERATION_CRON_JOB}")
    public void StartGeneratingDailyPdf(){
        statementController.GenerateDailyPdf();
    }

    @Scheduled(cron = "${GENERATION_CRON_JOB}")
    public void StartGeneratingWeeklyPdf(){
        statementController.GenerateWeeklyPdf();
    }

    @Scheduled(cron = "${GENERATION_CRON_JOB}")
    public void StartGeneratingMonthlyPdf(){
        statementController.GenerateMonthlyPdf();
    }
}
