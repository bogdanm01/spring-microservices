package com.boki.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkingPositionDetails {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;

    public WorkingPositionDetails(long id, String name){
        this.id = id;
        this.name = name;
    }

    public WorkingPositionDetails(){}
}
