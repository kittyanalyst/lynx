package com.innovatis.lynx.config.s3;

import javaslang.collection.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Map;
import java.util.Properties;

/**
 * Created by Ramakrishna Chalasani on 02/14/2017.
 */
public class S3PropertiesLoader implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {


    private static final String AWS_ACCESS_KEY = "AWS_ACCESS_KEY";
    private static final String AWS_SECRET_KEY = "AWS_SECRET_KEY";


    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

        ConfigurableEnvironment env = event.getEnvironment();
        Properties properties = new Properties();

        String accessKey = System.getenv(AWS_ACCESS_KEY);
        String secretKey = System.getenv(AWS_SECRET_KEY);


        Map map = HashMap.of("s3-properties.access-key", accessKey)
                .put("s3-properties.secret-key", secretKey)
                .filter(tuple -> StringUtils.isNotEmpty(tuple._2))
                .toJavaMap();
        properties.putAll(map);

        env.getPropertySources().addLast(new PropertiesPropertySource("s3-properties", properties));

    }
}
