package com.currenjin.exceptor.core;

public class ErrorResponse {
    public static ErrorResponse with(int httpCode, String reason) {
        return new ErrorResponse(httpCode, reason);
    }

    public ErrorResponse(int httpCode, String reason) {
        this.httpCode = httpCode;
        this.reason = reason;
    }

    int httpCode;
    String reason;

    public int getHttpCode() {
        return httpCode;
    }

    public String getReason() {
        return reason;
    }
}