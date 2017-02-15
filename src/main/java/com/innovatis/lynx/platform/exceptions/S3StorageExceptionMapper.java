package com.innovatis.lynx.platform.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
public class S3StorageExceptionMapper implements ExceptionMapper<S3StorageException> {
    @Override
    public Response toResponse(S3StorageException exception) {
        Response.Status status = Response.Status.SERVICE_UNAVAILABLE;

        ErrorMessage errorMessage =  new ErrorMessage.Builder()
                .code(status.getStatusCode())
                .message(exception.getMessage())
                .build();
        return Response.status(status).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();

    }
}
