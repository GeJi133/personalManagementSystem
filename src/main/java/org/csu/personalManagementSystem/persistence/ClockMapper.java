package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Clock;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClockMapper {

    //List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee);

    List<Clock> getClockByPage();

    List<Clock> getAllClock();
    List<Clock>  getClockById(String id);
    List<Clock> getClockByName(String name);


    //Long getTotal(@Param("emp") Employee employee);

    int updateClockByPrimaryKeySelective(Clock clock);
}


