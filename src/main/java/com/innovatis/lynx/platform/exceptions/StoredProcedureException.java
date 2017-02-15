package com.innovatis.lynx.platform.exceptions;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
public class StoredProcedureException extends RuntimeException {

    private int statusCode;
    private String statusMessage;

    public StoredProcedureException() {
        super();
    }

    public StoredProcedureException(int statusCode, String statusMessage) {
        super(String.format("%s (%d)", statusMessage, statusCode));

        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String getMessage() {
        return String.format("%d - %s", statusCode, statusMessage);
    }


    public static final class Builder {
        private String statusMessage;
        private int statusCode;

        private Builder() {
        }

        public static Builder aStoredProcedureException() {
            return new Builder();
        }

        public Builder withStatusMessage(String statusMessage) {
            this.statusMessage = statusMessage;
            return this;
        }

        public Builder withStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public StoredProcedureException build() {
            StoredProcedureException storedProcedureException = new StoredProcedureException();
            storedProcedureException.setStatusMessage(statusMessage);
            storedProcedureException.setStatusCode(statusCode);
            return storedProcedureException;
        }
    }
}
