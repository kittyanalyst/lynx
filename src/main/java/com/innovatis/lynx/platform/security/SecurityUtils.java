package com.innovatis.lynx.platform.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Ramakrishna Chalasani 02/01/2017..
 */
public final class SecurityUtils {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    public final static String X_LOGON_ID = "X-Logon-Id";

    private SecurityUtils() {}

    public static LogonUser getLoggedInUser() {

        logger.debug("Getting the user id of authenticated user.");

        SecurityContext securityContext = SecurityContextHolder.getContext();

        if (securityContext == null) {
            logger.debug("Spring security context does not exist.  Returning null.");
            return null;
        }

        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            logger.debug("Current user is anonymous.  Returning null.");
            return null;
        }

        if (!(authentication.getPrincipal() instanceof LogonUser)) {
            logger.debug("Current user is anonymous.  Returning null.");
            return null;
        }

        return (LogonUser)authentication.getPrincipal();
    }


}
