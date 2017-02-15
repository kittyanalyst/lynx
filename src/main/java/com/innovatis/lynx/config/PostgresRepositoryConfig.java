package com.innovatis.lynx.config;


import com.innovatis.lynx.common.Profiles;
import com.innovatis.lynx.platform.jpa.AuditingDateTimeProvider;
import com.innovatis.lynx.platform.jpa.DateTimeService;
import com.innovatis.lynx.platform.jpa.LogonIdAuditorAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by Ramakrishna Chalasani on 02/01/2017.
 */
@Profile({Profiles.APPLICATION})
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@Configuration
@EnableJpaRepositories(basePackages = {"com.innovatis.lynx.user.repository, com.innovatis.lynx.document.repository "},
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager")
public class PostgresRepositoryConfig {

    @Primary
    @Bean(name = "postgresDS")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresEntityManager(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(postgresDataSource())
                .packages("com.innovatis.lynx.user.domain," +
                        "com.innovatis.lynx.document.domain")
                .persistenceUnit("postgresPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager(
            @Qualifier("postgresEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new LogonIdAuditorAware();
    }

    @Bean
    public DateTimeProvider dateTimeProvider(DateTimeService dateTimeService) {
        return new AuditingDateTimeProvider(dateTimeService);
    }

}
