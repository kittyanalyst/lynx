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
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    private static final Logger logger = LoggerFactory.getLogger(GenericExceptionMapper.class);

    private static final String GENERIC_MSG = "An internal server error occurred.  Please contact System Admin for more information.";

    @Override
    public Response toResponse(Throwable exception) {

        logger.error("GenericExceptionMapper", exception);

        Response.Status errorStatus = Response.Status.INTERNAL_SERVER_ERROR;

        ErrorMessage errorMessage = new ErrorMessage.Builder()
                .code(errorStatus.getStatusCode())
                .message(GENERIC_MSG)
                .build();

        return Response.status(errorStatus).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();

    }
}