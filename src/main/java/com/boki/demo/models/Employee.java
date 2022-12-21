package com.boki.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee {

    @JsonIgnore
    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    public Employee(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee() {

    }
}
