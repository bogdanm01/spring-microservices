package com.boki.demo.models;

import com.boki.demo.enums.WorkingPositions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class WorkingPosition {
    @JsonIgnore
    private @Id long id;
    private String name;
    @OneToMany(mappedBy = "workingPosition")
    private List<Employee> employees;

    public WorkingPosition(long id, String name){
        this.id = id;
        this.name = name;
    }

    public WorkingPosition(){}

}
