package com.innovatis.lynx.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by Ramakrishna Chalasani 02/09/2017.
 */
@Configuration
public class SwaggerConfig {

    @Autowired
    private Environment env;

    @Bean
    public ApiListingResource swaggerResource() {
        return new ApiListingResource();
    }

    @Bean
    public SwaggerSerializers swaggerSerializers() {
        return new SwaggerSerializers();
    }

    @Bean
    public BeanConfig beanConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion(env.getProperty("info.build.version"));
        beanConfig.setResourcePackage(env.getProperty("resource.packages"));
        beanConfig.setBasePath("lynx-api");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);

        return beanConfig;
    }

}
