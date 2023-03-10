package com.boki.demo.services;

import com.boki.demo.dtos.EmployeeOverview;
import com.boki.demo.dtos.InsertEmployeeRequest;
import com.boki.demo.dtos.RoleDetails;
import com.boki.demo.dtos.WorkingPositionDetails;
import com.boki.demo.enums.Responses;
import com.boki.demo.models.Employee;
import com.boki.demo.repositories.EmployeeRepository;
import com.boki.demo.repositories.RoleRepository;
import com.boki.demo.repositories.WorkingPositionRepository;
import com.boki.demo.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private WorkingPositionRepository workingPositionRepository;

    public CustomResponse<ArrayList<EmployeeOverview>> getAll(){
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
        return new CustomResponse<>(Responses.SUCCESS.statusCode, Responses.SUCCESS.message, employees,true);
    }

    public CustomResponse<EmployeeOverview> getById(Long id){
        if(employeeRepository.findById(id).isPresent()) {
            Employee employee = employeeRepository.findById(id).get();
            EmployeeOverview employeeMapped = new EmployeeOverview();
            employeeMapped.setId(employee.getId());
            employeeMapped.setFirstName(employee.getFirstName());
            employeeMapped.setLastName(employee.getLastName());
            employeeMapped.setRole(new RoleDetails(employee.getRole().getId(), employee.getRole().getName()));
            employeeMapped.setWorkingPosition(new WorkingPositionDetails(employee.getWorkingPosition().getId(), employee.getWorkingPosition().getName()));
            return new CustomResponse(Responses.SUCCESS.statusCode, Responses.SUCCESS.message, employeeMapped, true);
        }
        else{
            return new CustomResponse(Responses.NO_DATA_FOUND.statusCode, Responses.NO_DATA_FOUND.message, null,false);
        }
    }

    public CustomResponse<EmployeeOverview> insert(InsertEmployeeRequest employee){
        Employee employeeMapped = new Employee();
        employeeMapped.setFirstName(employee.getFirstName());
        employeeMapped.setLastName(employee.getLastName());
        employeeMapped.setRole(roleRepository.findById(employee.getRoleId()).get());
        employeeMapped.setWorkingPosition(workingPositionRepository.findById(employee.getWorkingPositionId()).get());
        Employee savedEmployee = employeeRepository.save(employeeMapped);
        EmployeeOverview employeeOverviewMapped = new EmployeeOverview();
        employeeOverviewMapped.setFirstName(employee.getFirstName());
        employeeOverviewMapped.setLastName(employee.getLastName());
        employeeOverviewMapped.setRole(new RoleDetails(savedEmployee.getRole().getId(), savedEmployee.getRole().getName()));
        employeeOverviewMapped.setWorkingPosition(new WorkingPositionDetails(savedEmployee.getWorkingPosition().getId(), savedEmployee.getWorkingPosition().getName()));
        return new CustomResponse(Responses.EMPLOYEE_ADDED.statusCode,Responses.EMPLOYEE_ADDED.message, employeeOverviewMapped, true);
    }
}
