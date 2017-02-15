package com.innovatis;

import com.innovatis.lynx.common.Profiles;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Profile;

@Profile({Profiles.APPLICATION})
@SpringBootApplication(exclude = {
		FlywayAutoConfiguration.class
})
public class LynxApplication {

	public static void main(String[] args) {
		SpringApplication.run(LynxApplication.class, args);
	}
}
