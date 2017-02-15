package com.innovatis.lynx.platform.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationExceptionMapper.class);

    private static final String INTERNAL_SERVER_ERROR_MSG = "An internal server error occurred.  Please contact System Admin for more information.";

    @Override
    public Response toResponse(ApplicationException exception) {

        logger.error("ApplicationExceptionMapper", exception);

        int statusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();

        ErrorMessage errorMessage = new ErrorMessage.Builder()
                .code(statusCode)
                .message(INTERNAL_SERVER_ERROR_MSG)
                .build();

        return Response.status(statusCode).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }
}
