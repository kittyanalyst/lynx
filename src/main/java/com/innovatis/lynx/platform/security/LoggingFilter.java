package com.innovatis.lynx.platform.security;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Ramakrishna Chalasani 02/01/2017..
 */
@Order(Integer.MAX_VALUE)
public class LoggingFilter extends GenericFilterBean {

    public final static String LOGON_USER = "logonUser";
    public final static String REQUEST_IDENTIFIER = "requestId";
    public final static String ENDPONT = "endpoint";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        UUID requestId = UUID.randomUUID();
        String endpoint = httpRequest.getRequestURI();
        if(SecurityUtils.getLoggedInUser() != null) {
            String logonUser = SecurityUtils.getLoggedInUser().getLogonId();
            MDC.put(LOGON_USER, logonUser);
        }
        MDC.put(REQUEST_IDENTIFIER, requestId.toString());
        MDC.put(ENDPONT, endpoint);
        try {
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}
