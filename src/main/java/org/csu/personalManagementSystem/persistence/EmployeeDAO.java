package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Employee;

public interface EmployeeDAO {
    public Employee findId(Employee employee);
}
