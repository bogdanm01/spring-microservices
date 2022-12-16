package com.boki.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    public Employee(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Employee() {

    }

}
