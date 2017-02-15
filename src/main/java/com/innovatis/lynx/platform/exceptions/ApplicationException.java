package com.innovatis.lynx.platform.exceptions;

/**
 * Created by Khue Cung on 4/2/2016.
 */
public class ApplicationException extends RuntimeException {

    public ApplicationException(String msg) {
        super(msg);
    }

    public ApplicationException(Throwable t) {
        super(t);
    }

    public ApplicationException(String msg, Throwable t) {
        super(msg, t);
    }
}
