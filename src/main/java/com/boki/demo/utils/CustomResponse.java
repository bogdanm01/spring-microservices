package com.boki.demo.utils;

public class CustomResponse<T> {
    public String statusCode;
    public String message;
    public T data;
    public boolean succeeded;

    public CustomResponse(String statusCode, String message, T data, boolean succeeded){
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.succeeded = succeeded;
    }
}
