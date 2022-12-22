package com.boki.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDetails {

    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;

    public RoleDetails(long id, String name){
        this.id = id;
        this.name = name;
    }
    public RoleDetails(){}
}
