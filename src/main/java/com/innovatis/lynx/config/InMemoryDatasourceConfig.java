package com.innovatis.lynx.config;


import com.innovatis.lynx.common.Profiles;
import com.innovatis.lynx.platform.jpa.AuditingDateTimeProvider;
import com.innovatis.lynx.platform.jpa.DateTimeService;
import com.innovatis.lynx.platform.jpa.LogonIdAuditorAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by  Ramakrishna Chalasani 02/01/2017.
 */
@Profile(Profiles.INT_TEST)
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@Configuration
@EnableJpaRepositories(
        basePackages = { },
        entityManagerFactoryRef = "inMemoryEntityManagerFactory",
        transactionManagerRef = "inMemoryTransactionManager"
)
public class InMemoryDatasourceConfig {

    @Bean
    public DataSource inMemoryDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .build();
    }

    @Bean(name = "inMemoryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean inMemoryEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("");
        factoryBean.setDataSource(inMemoryDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setPersistenceUnitName("inMemoryPersistenceUnit");
        return factoryBean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");

        return jpaVendorAdapter;
    }

    @Bean(name = "inMemoryTransactionManager")
    public PlatformTransactionManager inMemoryTransactionManager(
            @Qualifier("inMemoryEntityManagerFactory") EntityManagerFactory inMemoryEntityManagerFactory) {
        return new JpaTransactionManager(inMemoryEntityManagerFactory);
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
