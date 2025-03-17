package com.logdbmanag.config;

import com.logdbmanag.controller.LogFileController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingManagerAutoConfiguration {
    LogFileController logFileController;

    @Autowired
    public LoggingManagerAutoConfiguration(LogFileController logFileController) {
        this.logFileController = logFileController;
    }

    @Bean
    public LogFileController logFileController() {
        return logFileController;
    }
}