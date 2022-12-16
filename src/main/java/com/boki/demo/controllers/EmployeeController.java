package com.boki.demo.controllers;

import com.boki.demo.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class EmployeeController {

    private ArrayList<Employee> mockData = new ArrayList<Employee>(Arrays.asList(
            new Employee(1L, "Marko Petrovic", "Entry level developer"),
            new Employee(2L, "Petar Markovic", "Junior developer")));

    @GetMapping("getAllEmpolyees")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Employee> getAllEmployees() {
        return mockData;
    }

    @GetMapping("getEmployee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable int id){
        return mockData.get(id - 1);
    }
}
