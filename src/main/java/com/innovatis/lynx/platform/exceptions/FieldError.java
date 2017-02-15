package com.innovatis.lynx.platform.exceptions;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Created by Khue Cung on 5/12/16.
 */
public class FieldError implements Serializable {

    private static final long serialVersionUID = -4861963098810822483L;

    private String field;
    private String message;

    public FieldError() {}

    public FieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        FieldError rhs = (FieldError) obj;
        return new EqualsBuilder()
                .append(this.field, rhs.field)
                .append(this.message, rhs.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(field)
                .append(message)
                .toHashCode();
    }
}
