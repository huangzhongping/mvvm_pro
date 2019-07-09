/*
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:NetworkConnectionException.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 */
package com.example.networkrequest.exception;

import java.io.IOException;

/**
 * 当有一个网络连接异常时应用程序的异常抛出。
 */
public class NetworkConnectionException extends IOException {
    public String msg; //用户提示信息
    public String exception; //服务器错误信息
    public int status;

    public NetworkConnectionException() {
        super();
    }

    public NetworkConnectionException(final String message) {
        super(message);
    }

    public NetworkConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NetworkConnectionException(final Throwable cause) {
        super(cause);
    }

    public NetworkConnectionException(final String msg, final String exception, final int status) {
        super(msg);
        this.status = status;
        this.exception = exception;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
