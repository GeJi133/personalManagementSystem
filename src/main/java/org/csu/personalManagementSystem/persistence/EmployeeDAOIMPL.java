package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Account;
import org.csu.personalManagementSystem.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;

@Repository
public class EmployeeDAOIMPL implements EmployeeDAO {
    @Autowired
    private DataSource dataSource;

    @Override
    public Employee findId(Employee employee) {
        try {
            Connection connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

