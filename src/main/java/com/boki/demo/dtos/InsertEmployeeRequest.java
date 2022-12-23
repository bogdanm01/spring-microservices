package com.boki.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertEmployeeRequest {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("role_id")
    private Long roleId;
    @JsonProperty("working_position_id")
    private Long workingPositionId;
}
