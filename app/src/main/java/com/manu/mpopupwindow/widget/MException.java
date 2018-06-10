package com.manu.mpopupwindow.widget;

/**
 *
 * @author: jzman
 * @time: 2018/6/5 0005 13:36
 */

public class MException extends RuntimeException{

    private String errorCode;

    public MException(String errorCode) {
        this.errorCode = errorCode;
    }

    public MException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return super.toString()+",MException{" +
                "errorCode='" + errorCode + '\'' +
                '}';
    }
}
