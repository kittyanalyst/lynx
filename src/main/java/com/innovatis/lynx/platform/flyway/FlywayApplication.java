package com.innovatis.lynx.platform.flyway;

import com.innovatis.lynx.common.Profiles;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

/**
 * Created by Ramakrishna Chalasani on 01/31/2017
 */
@Profile(Profiles.FLYWAY)
@SpringBootConfiguration
@ComponentScan("com.innvoatis.lynx.platform.flyway")
public class FlywayApplication implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(FlywayApplication.class);

    @Autowired
    private Flyway flyway;

    public static void main(String[] args) {
        SpringApplication.run(FlywayApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Running Flyway DB Migration Scripts");

        flyway.migrate();

        logger.info("Successfully completed running Flyway DB Migration Scripts");
    }
}
