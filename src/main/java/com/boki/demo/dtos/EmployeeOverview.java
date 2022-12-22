package com.boki.demo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeOverview {
    @JsonIgnore
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("role")
    private RoleDetails role;

    @JsonProperty("working_position")
    private WorkingPositionDetails workingPosition;
}
