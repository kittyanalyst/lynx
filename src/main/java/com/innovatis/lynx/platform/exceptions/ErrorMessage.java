package com.innovatis.lynx.platform.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Carries payload for an error message.
 *
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage implements Serializable {

    private int code;

    private String message;

    private List<FieldError> errors;

    public ErrorMessage() {}

    protected ErrorMessage(Builder builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.errors = builder.errors;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }

    public static class Builder {

        private int code;
        private String message;
        private List<FieldError> errors;

        public Builder() {}

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder errors(List<FieldError> errors) {
            if (this.errors == null) {
                this.errors = new ArrayList<>();
            }
            this.errors.addAll(errors);
            return this;
        }

        public ErrorMessage build() {
            return new ErrorMessage(this);
        }
    }
}
