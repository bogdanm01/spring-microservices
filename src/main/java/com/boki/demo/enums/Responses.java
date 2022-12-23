package com.boki.demo.enums;

public enum Responses {
    EMPLOYEE_ADDED("200 OK","Employee added successfully"),
    SUCCESS("200 OK", "Success"),
    INSERT_FAILED("404 BAD REQUEST", "Could not insert data"),
    NO_DATA_FOUND("404 BAD REQUEST", "Could not find data");
    public String statusCode;
    public String message;

    Responses(String statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }

}
