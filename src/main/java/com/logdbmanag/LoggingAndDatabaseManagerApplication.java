package com.logdbmanag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, SecurityAutoConfiguration.class})
public class LoggingAndDatabaseManagerApplication {

    //TODO: create two versions of this project: java11 version and java 21 version
    public static void main(String[] args) {
        SpringApplication.run(LoggingAndDatabaseManagerApplication.class, args);
    }

}
