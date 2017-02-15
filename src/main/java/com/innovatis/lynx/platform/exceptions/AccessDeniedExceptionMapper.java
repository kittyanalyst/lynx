package com.innovatis.lynx.platform.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by exceptions.
 */
@Provider
@Component
public class AccessDeniedExceptionMapper implements ExceptionMapper<AccessDeniedException> {

    private static final Logger logger = LoggerFactory.getLogger(AccessDeniedExceptionMapper.class);

    @Override
    public Response toResponse(AccessDeniedException exception) {
        logger.error("AccessDeniedExceptionMapper", exception);

        int statusCode = Response.Status.FORBIDDEN.getStatusCode();

        ErrorMessage errorMessage = new ErrorMessage.Builder()
                .code(statusCode)
                .message(exception.getMessage())
                .build();

        return Response.status(statusCode).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }
}
