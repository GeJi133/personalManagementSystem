package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.persistence.EmployeeCareerMapper;
import org.csu.personalManagementSystem.persistence.EmployeeLanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCareerService {

    @Autowired
    EmployeeCareerMapper employeeCareerMapper;

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

    public List<Employee> getEmployeeCareerByPage(){
        return employeeCareerMapper.getEmployeeCareerByPage();
    }

    public List<Employee> getAllEmployeeCareer(){
        return employeeCareerMapper.getAllEmployeeCareer();
    }

    public  List<Employee>  getEmployeeCareerById(String id){

        return employeeCareerMapper.getEmployeeCareerById(id);
    }

    public List<Employee> getEmployeeCareerByName(String name){
        return employeeCareerMapper.getEmployeeCareerByName(name);
    }

    public Integer addEmpCareer(Employee employee){
        int result = employeeCareerMapper.insertCareerSelective(employee);
        return result;
    }

    public Integer deleteEmpCareerByid(String id) {
        return employeeCareerMapper.deleteCareerByPrimaryKey(id);
    }

    public Integer updateEmpCareer(Employee employee) {
        return employeeCareerMapper.updateCareerByPrimaryKeySelective(employee);
    }
}

