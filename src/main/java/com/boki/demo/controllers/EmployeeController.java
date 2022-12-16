package com.boki.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class EmployeeController {

    private String[] mockData = {"Mika", "Zika", "Peka"};

    @GetMapping("getAllEmpolyees")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<String> getAllEmployees() {
        return new ArrayList<String>(Arrays.asList(mockData));
    }

    @GetMapping("getEmployee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getEmployeeById(@PathVariable int id){
        return mockData[id - 1];
    }
}
