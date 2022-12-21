package com.boki.demo.seeder;

import com.boki.demo.dtos.EmployeeBase;
import com.boki.demo.enums.Roles;
import com.boki.demo.enums.WorkingPositions;
import com.boki.demo.models.Employee;
import com.boki.demo.models.Role;
import com.boki.demo.models.WorkingPosition;
import com.boki.demo.repositories.EmployeeRepository;
import com.boki.demo.repositories.RoleRepository;
import com.boki.demo.repositories.WorkingPositionRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class DatabaseSeeder {
    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;
    private WorkingPositionRepository workingPositionRepository;
    
    //Insert absolute path to employees.json file here before running the app
    private String absolutePath = "";

    @Autowired
    public DatabaseSeeder(
            EmployeeRepository employeeRepository,
            RoleRepository roleRepository,
            WorkingPositionRepository workingPositionRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.workingPositionRepository = workingPositionRepository;
    }
    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRolesTable();
        seedWorkingPositionsTable();
        seedEmployeesTable();
    }

    public void seedRolesTable(){
        roleRepository.save(new Role(Roles.ADMINISTRATOR.id, Roles.ADMINISTRATOR.name));
        roleRepository.save(new Role(Roles.EMPLOYEE.id, Roles.EMPLOYEE.name));
    }

    public void seedWorkingPositionsTable(){
        workingPositionRepository.save(new WorkingPosition(WorkingPositions.ENTRY_DEVELOPER.id,
                WorkingPositions.ENTRY_DEVELOPER.name));
        workingPositionRepository.save(new WorkingPosition(WorkingPositions.JUNIOR_DEVELOPER.id,
                WorkingPositions.JUNIOR_DEVELOPER.name));
        workingPositionRepository.save(new WorkingPosition(WorkingPositions.MEDIOR_DEVELOPER.id,
                WorkingPositions.MEDIOR_DEVELOPER.name));
        workingPositionRepository.save(new WorkingPosition(WorkingPositions.SENIOR_DEVELOPER.id,
                WorkingPositions.SENIOR_DEVELOPER.name));
        workingPositionRepository.save(new WorkingPosition(WorkingPositions.TEAM_LEAD.id,
                WorkingPositions.TEAM_LEAD.name));
    }

    public void seedEmployeesTable(){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<EmployeeBase>> typeReference = new TypeReference<List<EmployeeBase>>(){};
        Random random = new Random();
        try {
            List<EmployeeBase> demoEmployees = mapper.readValue(new File(absolutePath),
                    typeReference);
        List<Employee> employees = new ArrayList<>();
            for (EmployeeBase demoEmployee: demoEmployees
                 ) {
                Employee employee = new Employee();
                employee.setFirstName(demoEmployee.getFirstName());
                employee.setLastName(demoEmployee.getLastName());
                employee.setRole(roleRepository.findById(random.nextLong(2)+1).get());
                employee.setWorkingPosition(workingPositionRepository.findById(random.nextLong(5)+1).get());
                employeeRepository.save(employee);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
