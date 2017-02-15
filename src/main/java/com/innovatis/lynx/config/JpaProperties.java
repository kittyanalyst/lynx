package com.innovatis.lynx.config;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.transaction.jta.platform.internal.BitronixJtaPlatform;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ramakrishna Chalasani 01/31/2017.
 */
@ConfigurationProperties(prefix = "jpa-properties")
public class JpaProperties {

    public static final int DEFAULT_FETCH_SIZE = 300;
    public static final String DEFAULT_JTA_PLATFORM = BitronixJtaPlatform.class.getName();
    public static final String DEFAULT_TRANSACTION_TYPE = "JTA";

    private boolean showSql = false;
    private boolean generateDdl = false;
    private int fetchSize = DEFAULT_FETCH_SIZE;
    private String ddlAuto;
    private String jtaPlaform = DEFAULT_JTA_PLATFORM;
    private String transactionType = DEFAULT_TRANSACTION_TYPE;

    private String dialect;
    private Boolean useJdbcMetadataDefaults;

    public Map<String, Object> toPropertiesMap() {

        Map<String, Object> properties = new HashMap<>();

        properties.put("hibernate.jdbc.fetch_size", fetchSize);

        if (StringUtils.isNotBlank(jtaPlaform)) {
            properties.put("hibernate.transaction.jta.platform", jtaPlaform);
        }

        if (StringUtils.isNotBlank(transactionType)) {
            properties.put("javax.persistence.transactionType", transactionType);
        }

        if (StringUtils.isNotBlank(ddlAuto)) {
            properties.put("hibernate.hbm2ddl.auto", ddlAuto);
        }

        if (useJdbcMetadataDefaults != null) {
            properties.put("hibernate.temp.use_jdbc_metadata_defaults", useJdbcMetadataDefaults);
        }

        if (StringUtils.isNotBlank(dialect)) {
            properties.put("hibernate.dialect", dialect);
        }

        return properties;
    }

    public boolean isShowSql() {
        return showSql;
    }

    public void setShowSql(boolean showSql) {
        this.showSql = showSql;
    }

    public boolean isGenerateDdl() {
        return generateDdl;
    }

    public void setGenerateDdl(boolean generateDdl) {
        this.generateDdl = generateDdl;
    }

    public int getFetchSize() {
        return fetchSize;
    }

    public void setFetchSize(int fetchSize) {
        this.fetchSize = fetchSize;
    }

    public String getDdlAuto() {
        return ddlAuto;
    }

    public void setDdlAuto(String ddlAuto) {
        this.ddlAuto = ddlAuto;
    }

    public String getJtaPlaform() {
        return jtaPlaform;
    }

    public void setJtaPlaform(String jtaPlaform) {
        this.jtaPlaform = jtaPlaform;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public Boolean getUseJdbcMetadataDefaults() {
        return useJdbcMetadataDefaults;
    }

    public void setUseJdbcMetadataDefaults(Boolean useJdbcMetadataDefaults) {
        this.useJdbcMetadataDefaults = useJdbcMetadataDefaults;
    }
}
