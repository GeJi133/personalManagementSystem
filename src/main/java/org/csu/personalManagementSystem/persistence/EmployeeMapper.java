package org.csu.personalManagementSystem.persistence;

import org.apache.ibatis.annotations.Param;
import org.csu.personalManagementSystem.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    //List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee);

    List<Employee> getEmployeeByPage();
    //Long getTotal(@Param("emp") Employee employee);
    int insertSelective(Employee employee);

    int deleteByPrimaryKey(String id);
}
