package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.Salary;
import org.csu.personalManagementSystem.persistence.EmployeeLanguageMapper;
import org.csu.personalManagementSystem.persistence.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired

    SalaryMapper salaryMapper;

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


    public List<Salary> getAllSalary(){
        return salaryMapper.getAllSalary();
    }

    public  List<Salary>  getSalaryById(String id){

        return salaryMapper.getSalaryById(id);
    }

    public List<Salary> getSalaryByName(String name){
        return salaryMapper.getSalaryByName(name);
    }

    public List<Salary> getSalaryByPage(){
        return salaryMapper.getSalaryByPage();
    }

    public Integer updateSalary(Salary salary) {
        return salaryMapper.updateSalaryByPrimaryKeySelective(salary);
    }
}

