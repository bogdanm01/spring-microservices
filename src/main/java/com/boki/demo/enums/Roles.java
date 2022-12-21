package com.boki.demo.enums;

public enum Roles {
    ADMINISTRATOR(1,"Administrator"),
    EMPLOYEE(2,"Employee");

    public long id;
    public String name;

    Roles(long id, String name){
        this.id = id;
        this.name = name;
    }
}
