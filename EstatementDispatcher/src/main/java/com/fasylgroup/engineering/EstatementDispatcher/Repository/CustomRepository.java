package com.fasylgroup.engineering.EstatementDispatcher.Repository;

import com.fasterxml.uuid.Generators;
import com.fasylgroup.engineering.EstatementDispatcher.Configuration.DBConfiguration;
import com.fasylgroup.engineering.EstatementDispatcher.Model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class CustomRepository {
    @Autowired
    private DBConfiguration dbConfiguration;
    private Logger logger = LoggerFactory.getLogger(CustomRepository.class);
    @Value("${TABLE_NAME}")
    private String tableName;
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

    public CustomerInfo GetCustomerName(String custAcNo){
        CustomerInfo customerInfo = new CustomerInfo();
        try{
            Connection connection = dbConfiguration.dataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT a.AC_DESC, b.EMAIL FROM STTM_CUST_ACCOUNT a WHERE CUST_AC_NO = ?");
            preparedStatement.setString(1, custAcNo);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                customerInfo.setCustName(set.getString(1));
                customerInfo.setCustEmail(set.getString(3));
            }
            preparedStatement.close();
            set.close();
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            logger.error("Exception in GetCustomerNo: {}",ex.getMessage());
        }
        return customerInfo;
    }

    public Map<String, String> getAppConfig() {
        Map<String, String> config = new HashMap<>();
        try {
            try (Connection connection1 = dbConfiguration.dataSource().getConnection();
                 PreparedStatement statement = connection1.prepareStatement("SELECT * FROM CSTM_APP_CONFIG");
                 ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    config.put(set.getString("KEY"), set.getString("VALUE"));
                }
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }

        return config;
    }

    public void UpdateLog(SttbScheduledStatements statement){
        try{
            Connection conn = dbConfiguration.dataSource().getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE "+tableName+" SET STATUS = ?, STMT_DT_SEND = ? WHERE GUID = ? AND AC_NO = ?");
            stmt.setString(1, statement.getStatus());
            stmt.setDate(2, new java.sql.Date(statement.getStmtDtSend().getTime()));
            stmt.setString(3, statement.getGuid());
            stmt.setString(4, statement.getAcNo());
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
