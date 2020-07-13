package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCareerMapper {

    //List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee);

    List<Employee> getEmployeeCareerByPage();
    //Long getTotal(@Param("emp") Employee employee);

    List<Employee> getAllEmployeeCareer();
    List<Employee>  getEmployeeCareerById(String id);
    public List<Employee> getEmployeeCareerByName(String name);

    int insertCareerSelective(Employee employee);

    int deleteCareerByPrimaryKey(String id);

    int updateCareerByPrimaryKeySelective(Employee employee);
}
