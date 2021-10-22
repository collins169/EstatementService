package com.fasylgroup.engineering.EstatementDispatcher.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("oracle")
public class DBConfiguration {
    private Logger log = LoggerFactory.getLogger(DBConfiguration.class);

    @NotNull
    private String url;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Value("${oracle.datasource}")
    private String datasource;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    @Bean()
    public DataSource dataSource(){
        log.info("==============Intializing database ================");
        log.info("user: " + getUsername());
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(getDatasource());
        hikariConfig.setJdbcUrl(getUrl());
        hikariConfig.setUsername(getUsername());
        hikariConfig.setPassword(getPassword());

        hikariConfig.setMaximumPoolSize(20);
        hikariConfig.setConnectionTestQuery("SELECT SYSDATE FROM DUAL");
        hikariConfig.setPoolName("springHikariCP");

        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

        HikariDataSource dataSource;
        dataSource=  new HikariDataSource(hikariConfig);
        try {
            if (dataSource.getConnection() == null) {
                log.info("============== Unable to connect database ================");
            }
        }catch (SQLException ex){
            log.error(ex.getSQLState());
        }
        return dataSource;
    }

    @Bean(name = "getAppConfigDB")
    public Map<String, String> getAppConfig() {
        log.info("==================== Loading App Config Table ====================");
        Map<String, String> config = new HashMap<>();
        try {
            try (Connection connection1 = dataSource().getConnection();
                 PreparedStatement statement = connection1.prepareStatement("SELECT * FROM CSTM_APP_CONFIG");
                 ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    config.put(set.getString("KEY"), set.getString("VALUE"));
                }
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
        log.info("==================== App Config Loaded ====================");
        return config;
    }
}

