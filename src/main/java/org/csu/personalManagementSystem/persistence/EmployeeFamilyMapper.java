package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeFamilyMapper {

    //List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee);

    List<Employee> getEmployeeFamilyByPage();
    //Long getTotal(@Param("emp") Employee employee);

    List<Employee> getAllEmployeeFamily();
    List<Employee>  getEmployeeFamilyById(String id);
    public List<Employee> getEmployeeFamilyByName(String name);

    int insertFamilySelective(Employee employee);

    int deleteFamilyByPrimaryKey(String id);

    int updateFamilyByPrimaryKeySelective(Employee employee);
}
