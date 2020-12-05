package com.manu.mpopupwindow;

/**
 * @Desc: 异常
 * @Author: jzman
 */
public class MException extends RuntimeException{
    private String message;
    public MException() {
    }

    public MException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "MException{" +
                "message='" + message + '\'' +
                '}';
    }
}
