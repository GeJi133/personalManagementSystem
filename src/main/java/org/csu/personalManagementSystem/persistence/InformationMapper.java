package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InformationMapper {
    Employee seeInformation(String id);
    void updateInformation(Employee newEmployee);
    ArrayList<Employee> seeAllEmployeesInformation();
    ArrayList<Employee> seePracticeEmployeesInformation();
    ArrayList<Employee> seeFormalEmployeesInformation();
}
