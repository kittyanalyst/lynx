package com.innovatis.lynx.platform.flyway;

import com.innovatis.lynx.common.Profiles;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by Ramakrishna Chalasani on 01/31/2017.
 */
@Profile(Profiles.FLYWAY)
@Configuration
public class FlywayDataSourceConfig {

    @FlywayDataSource
    @Primary
    @Bean(name = "postgresDS")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleDS")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }

}
