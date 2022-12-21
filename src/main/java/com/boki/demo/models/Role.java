package com.boki.demo.models;

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
public class Role {

    @JsonIgnore
    private @Id @GeneratedValue Long id;

    private String name;
    @OneToMany(mappedBy = "role")
    private List<Employee> employees;

    public Role(long id, String name){
        this.id = id;
        this.name = name;
    }
    Role(){};
}

