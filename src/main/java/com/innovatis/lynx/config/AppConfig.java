package com.innovatis.lynx.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.innovatis.lynx.common.Profiles;
import com.innovatis.lynx.platform.jpa.ConstantDateTimeService;
import com.innovatis.lynx.platform.jpa.CurrentDateTimeService;
import com.innovatis.lynx.platform.jpa.DateTimeService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * Created by Ramakrishna Chalasani 02/01/2017.
 */
@Configuration
public class AppConfig {

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }


    @Profile(Profiles.APPLICATION)
    @Bean
    public DateTimeService currentDateTimeService() {
        return new CurrentDateTimeService();
    }

    @Profile(Profiles.INT_TEST)
    @Bean
    public DateTimeService constantDateTimeService() {
        return new ConstantDateTimeService();
    }


    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }

}
