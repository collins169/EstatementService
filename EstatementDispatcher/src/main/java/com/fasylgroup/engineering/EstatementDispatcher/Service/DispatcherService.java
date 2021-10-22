package com.fasylgroup.engineering.EstatementDispatcher.Service;

import com.fasylgroup.engineering.EstatementDispatcher.Configuration.DBConfiguration;
import com.fasylgroup.engineering.EstatementDispatcher.Controller.EmailController;
import com.fasylgroup.engineering.EstatementDispatcher.Controller.StatementController;
import com.fasylgroup.engineering.EstatementDispatcher.Repository.CustomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DispatcherService {

    Logger logger = LoggerFactory.getLogger(DispatcherService.class);
    @Autowired
    private StatementController statementController;
    @Autowired
    private DBConfiguration dbConfiguration;
    @Autowired
    private EmailController emailController;
    @Autowired
    private CustomRepository repository;

    public DispatcherService(StatementController statementController, DBConfiguration dbConfiguration, EmailController emailController, CustomRepository repository) {
        this.statementController = statementController;
        this.dbConfiguration = dbConfiguration;
        this.emailController = new EmailController(dbConfiguration, repository);
        this.repository = repository;
    }

    @Scheduled(cron = "${CRON_JOB}")
    public void DispatchEmail(){
        statementController.fetchAndDispatch();
    }
}
