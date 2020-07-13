package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryMapper {

    //List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee);

    List<Salary> getSalaryByPage();

    List<Salary> getAllSalary();
    List<Salary>  getSalaryById(String id);
    public List<Salary> getSalaryByName(String name);


    //Long getTotal(@Param("emp") Employee employee);

    int updateSalaryByPrimaryKeySelective(Salary salary);
}

