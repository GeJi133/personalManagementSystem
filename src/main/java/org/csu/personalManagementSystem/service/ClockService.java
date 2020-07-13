package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Clock;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.Salary;
import org.csu.personalManagementSystem.persistence.ClockMapper;
import org.csu.personalManagementSystem.persistence.EmployeeLanguageMapper;
import org.csu.personalManagementSystem.persistence.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockService {

    @Autowired

    ClockMapper clockMapper;

    /*public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee);
        //Long total = employeeMapper.getTotal(employee);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        //bean.setTotal(total);
        return bean;
    }*/


    public List<Clock> getAllClock(){
        return clockMapper.getAllClock();
    }

    public  List<Clock>  getClockById(String id){

        return clockMapper.getClockById(id);
    }

    public List<Clock> getClockByName(String name){
        return clockMapper.getClockByName(name);
    }

    public List<Clock> getClockByPage(){
        return clockMapper.getClockByPage();
    }

    public Integer updateClock(Clock clock) {
        return clockMapper.updateClockByPrimaryKeySelective(clock);
    }
}

