package com.innovatis.lynx.platform.jpa;


import com.innovatis.lynx.platform.security.LogonUser;
import com.innovatis.lynx.platform.security.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;

/**
 * Created by Ramakrishna Chalasani 02/01/2017.
 */
public class LogonIdAuditorAware implements AuditorAware<String> {

    private static final Logger logger = LoggerFactory.getLogger(LogonIdAuditorAware.class);

    @Override
    public String getCurrentAuditor() {
        LogonUser loggedInUser = SecurityUtils.getLoggedInUser();

        return loggedInUser != null ? loggedInUser.getLogonId() : null;
    }

}
