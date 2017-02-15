package com.innovatis.lynx.config.s3;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * Created by Ramakrishna Chalasani 02/14/2017.
 */
@Configuration
@EnableConfigurationProperties (S3Properties.class)
public class S3Config {

    @Autowired
    private S3Properties s3Properties;

    @Bean
    public AmazonS3 s3Client() {
        Assert.notNull(s3Properties.getAccessKey(), "Acess Key is null. Please check AWS_ACCESS_KEY is set in environment variables.");
        Assert.notNull(s3Properties.getSecretKey(), "Secret Key is null. Please check AWS_SECRET_KEY is set in environment variables.");
        AmazonS3 localClient = new AmazonS3Client(new BasicAWSCredentials(s3Properties.getAccessKey(), s3Properties.getSecretKey()));

        return localClient;
    }
}
