package com.logdbmanag.config;

import com.logdbmanag.constant.AppConstant;
import com.logdbmanag.constant.ErrorMessage;
import com.logdbmanag.exception.exceptions.FunctionalityNotAvailableException;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class DotenvConfig {
    @Bean
    Dotenv dotenv() {
        try {
            return Dotenv.configure()
                .filename(AppConstant.DOTENV_FILENAME)
                .load();
        } catch (DotenvException ex) {
            throw new FunctionalityNotAvailableException(ErrorMessage.FUNCTIONALITY_NOT_AVAILABLE);
        }
    }
}