package com.innovatis.lynx.platform.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
@Provider
@Component
public class AuthenticationExceptionMapper implements ExceptionMapper<AuthenticationException> {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationExceptionMapper.class);

    @Override
    public Response toResponse(AuthenticationException exception) {
        logger.error("AuthenticationExceptionMapper", exception);

        int statusCode = Response.Status.UNAUTHORIZED.getStatusCode();

        ErrorMessage errorMessage = new ErrorMessage.Builder()
                .code(statusCode)
                .message(exception.getMessage())
                .build();

        return Response.status(statusCode).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }
}
