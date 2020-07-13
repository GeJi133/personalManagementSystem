package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeLanguageMapper {

    //List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee);

    List<Employee> getEmployeeLanguageByPage();
    //Long getTotal(@Param("emp") Employee employee);

    List<Employee> getAllEmployeeLanguage();
    List<Employee>  getEmployeeLanguageById(String id);
    public List<Employee> getEmployeeLanguageByName(String name);

    int insertLanguageSelective(Employee employee);

    int deleteLanguageByPrimaryKey(String id);

    int updateLanguageByPrimaryKeySelective(Employee employee);
}
