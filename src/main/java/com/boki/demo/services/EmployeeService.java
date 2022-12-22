package com.boki.demo.services;

import com.boki.demo.dtos.EmployeeOverview;
import com.boki.demo.dtos.RoleDetails;
import com.boki.demo.dtos.WorkingPositionDetails;
import com.boki.demo.models.Employee;
import com.boki.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public ArrayList<EmployeeOverview> getAll(){
        Iterable<Employee> iterable = employeeRepository.findAll();
        ArrayList<EmployeeOverview> employees = new ArrayList<>();
        for (Employee item:
             iterable) {
            EmployeeOverview employeeMapped = new EmployeeOverview();
            employeeMapped.setId(item.getId());
            employeeMapped.setFirstName(item.getFirstName());
            employeeMapped.setLastName(item.getLastName());
            employeeMapped.setRole(new RoleDetails(item.getRole().getId(), item.getRole().getName()));
            employeeMapped.setWorkingPosition(new WorkingPositionDetails(item.getWorkingPosition().getId(), item.getWorkingPosition().getName()));
            employees.add(employeeMapped);
        }
        return employees;
    }

    public EmployeeOverview getById(Long id){
        if(employeeRepository.findById(id).isPresent()) {
            Employee employee = employeeRepository.findById(id).get();
            EmployeeOverview employeeMapped = new EmployeeOverview();
            employeeMapped.setId(employee.getId());
            employeeMapped.setFirstName(employee.getFirstName());
            employeeMapped.setLastName(employee.getLastName());
            employeeMapped.setRole(new RoleDetails(employee.getRole().getId(), employee.getRole().getName()));
            employeeMapped.setWorkingPosition(new WorkingPositionDetails(employee.getWorkingPosition().getId(), employee.getWorkingPosition().getName()));
            return employeeMapped;
        }
        else{
            return null;
        }
    }
}
