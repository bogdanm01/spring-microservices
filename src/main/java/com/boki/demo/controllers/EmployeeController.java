package com.boki.demo.controllers;

import com.boki.demo.dtos.EmployeeOverview;
import com.boki.demo.models.Employee;
import com.boki.demo.services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private ArrayList<Employee> mockData = new ArrayList<Employee>(Arrays.asList(
            new Employee(1L, "Marko", "Petrovic"),
            new Employee(2L, "Petar", "Markovic")));

    @GetMapping("getAllEmployees")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<EmployeeOverview> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("getEmployee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        EmployeeOverview employee = employeeService.getById(id);
        if(employee != null){
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }

        return new ResponseEntity<>("Employee with specified id doesn't exist",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("insertEmployee")
    public ResponseEntity<?> insertEmployee(@RequestBody Employee employee) {
        // TODO: Implement insert employee endpoint
        return null;
    }
}
