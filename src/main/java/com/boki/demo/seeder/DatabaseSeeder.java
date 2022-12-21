package com.boki.demo.seeder;

import com.boki.demo.enums.Roles;
import com.boki.demo.enums.WorkingPositions;
import com.boki.demo.models.Role;
import com.boki.demo.models.WorkingPosition;
import com.boki.demo.repositories.EmployeeRepository;
import com.boki.demo.repositories.RoleRepository;
import com.boki.demo.repositories.WorkingPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DatabaseSeeder {
    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;
    private WorkingPositionRepository workingPositionRepository;

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
            //TO BE IMPLEMENTED
    }

}
