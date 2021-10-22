package com.fasylgroup.engineering.EstatementGenerator.Configuration;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public DataSource dataSource() throws SQLException {

        log.info("==============Intializing database ================");
        log.info("user: " + getUsername());

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setURL(url);
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }
}

