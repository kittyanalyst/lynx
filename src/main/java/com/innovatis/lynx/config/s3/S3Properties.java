package com.innovatis.lynx.config.s3;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * Created by Ramakrishna Chalasani 02/14/2017.
 */
@ConfigurationProperties (prefix="s3-properties")
public class S3Properties implements Serializable{



    private String accessKey;
    private String secretKey;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
