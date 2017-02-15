package com.innovatis.lynx.platform.exceptions;

import org.apache.cxf.validation.ResponseConstraintViolationException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
@Provider
@Component("validationExceptionMapper")
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {
        Response.Status errorStatus = Response.Status.BAD_REQUEST;

        List<FieldError> errors = new ArrayList<>();

        ErrorMessage.Builder builder;
        if (exception instanceof ConstraintViolationException) {

            ConstraintViolationException constraintViolationException = (ConstraintViolationException)exception;
            if (constraintViolationException.getConstraintViolations() != null) {
                constraintViolationException.getConstraintViolations().forEach(constraintViolation -> {
                    errors.add(new FieldError(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));
                });
            }
            if (!(constraintViolationException instanceof ResponseConstraintViolationException)) {
                errorStatus = Response.Status.BAD_REQUEST;
            }
            builder = new ErrorMessage.Builder().code(errorStatus.getStatusCode()).message("Validation Failed");
        } else {
            builder = new ErrorMessage.Builder().code(errorStatus.getStatusCode()).message(exception.getMessage());
        }


        if (!errors.isEmpty()) {
            builder.errors(errors);
        }

        return Response.status(errorStatus).entity(builder.build()).type(MediaType.APPLICATION_JSON).build();
    }
}

