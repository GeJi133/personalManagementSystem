package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.persistence.EmployeeFamilyMapper;
import org.csu.personalManagementSystem.persistence.EmployeeLanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeFamilyService {

    @Autowired
    EmployeeFamilyMapper employeeFamilyMapper;

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

    public List<Employee> getEmployeeFamilyByPage(){
        return employeeFamilyMapper.getEmployeeFamilyByPage();
    }

    public List<Employee> getAllEmployeeFamily(){
        return employeeFamilyMapper.getAllEmployeeFamily();
    }

    public  List<Employee>  getEmployeeFamilyById(String id){

        return employeeFamilyMapper.getEmployeeFamilyById(id);
    }

    public List<Employee> getEmployeeFamilyByName(String name){
        return employeeFamilyMapper.getEmployeeFamilyByName(name);
    }

    public Integer addEmpFamily(Employee employee){
        int result = employeeFamilyMapper.insertFamilySelective(employee);
        return result;
    }

    public Integer deleteEmpFamilyByid(String id) {
        return employeeFamilyMapper.deleteFamilyByPrimaryKey(id);
    }

    public Integer updateEmpFamily(Employee employee) {
        return employeeFamilyMapper.updateFamilyByPrimaryKeySelective(employee);
    }
}

