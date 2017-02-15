package com.innovatis.lynx.platform.exceptions;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
public class S3StorageException extends RuntimeException {

    public S3StorageException(String msg) {super(msg);}
    public S3StorageException(String msg, Throwable throwable) {super(msg, throwable);}
}
