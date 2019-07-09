package com.example.networkrequest.exception;

public class BaseException extends RuntimeException{

//    private String errorCode;
//
//    private String errorMsg;

    public BaseException(String detailMessage) {
//        this.errorMsg = detailMessage;
    }

    public BaseException(String errorCode, String errorMessage) {
        super(errorMessage);
    }

//    public String getErrorMsg() {
//        return errorMsg;
//    }
//
//    public void setErrorMsg(String errorMsg) {
//        this.errorMsg = errorMsg;
//    }
//
//    public String getErrorCode() {
//        return errorCode;
//    }
}
