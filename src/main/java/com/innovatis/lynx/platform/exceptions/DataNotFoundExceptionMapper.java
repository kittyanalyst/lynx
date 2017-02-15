package com.innovatis.lynx.platform.exceptions;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
@Provider
@Component("dataNotFoundExceptionMapper")
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException exception) {

        Response.Status errorStatus = Response.Status.BAD_REQUEST;

        ErrorMessage errorMessage = new ErrorMessage.Builder()
                .code(errorStatus.getStatusCode())
                .message(exception.getMessage())
                .build();

        return Response.status(errorStatus).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }
}
