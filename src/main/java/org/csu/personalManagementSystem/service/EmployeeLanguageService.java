package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.persistence.EmployeeLanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLanguageService {

    @Autowired
    EmployeeLanguageMapper employeeLanguageMapper;

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

    public List<Employee> getEmployeeLanguageByPage(){
        return employeeLanguageMapper.getEmployeeLanguageByPage();
    }

    public List<Employee> getAllEmployeeLanguage(){
        return employeeLanguageMapper.getAllEmployeeLanguage();
    }

    public  List<Employee>  getEmployeeLanguageById(String id){

        return employeeLanguageMapper.getEmployeeLanguageById(id);
    }

    public List<Employee> getEmployeeLanguageByName(String name){
        return employeeLanguageMapper.getEmployeeLanguageByName(name);
    }

    public Integer addEmpLanguage(Employee employee){
        int result = employeeLanguageMapper.insertLanguageSelective(employee);
        return result;
    }

    public Integer deleteEmpLanguageByid(String id) {
        return employeeLanguageMapper.deleteLanguageByPrimaryKey(id);
    }

    public Integer updateEmpLanguage(Employee employee) {
        return employeeLanguageMapper.updateLanguageByPrimaryKeySelective(employee);
    }
}
