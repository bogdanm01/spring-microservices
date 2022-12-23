package com.boki.demo.controllers;

import com.boki.demo.dtos.EmployeeOverview;
import com.boki.demo.dtos.InsertEmployeeRequest;
import com.boki.demo.models.Employee;
import com.boki.demo.services.EmployeeService;
import com.boki.demo.utils.CustomResponse;
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
    public ResponseEntity<?> getAllEmployees() {
        CustomResponse<ArrayList<EmployeeOverview>> response = employeeService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getEmployee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        CustomResponse<EmployeeOverview> response = employeeService.getById(id);
        if(response.succeeded){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("insertEmployee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> insertEmployee(@RequestBody InsertEmployeeRequest employee) {
        CustomResponse<EmployeeOverview> response = employeeService.insert(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
