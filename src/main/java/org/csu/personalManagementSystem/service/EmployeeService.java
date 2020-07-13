package org.csu.personalManagementSystem.service;

import com.github.pagehelper.PageInfo;
import org.csu.personalManagementSystem.persistence.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import org.csu.personalManagementSystem.domain.RespPageBean;
import org.csu.personalManagementSystem.domain.Employee;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

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

    public List<Employee> getEmployeeByPage(){
        return employeeMapper.getEmployeeByPage();
    }

    public Integer addEmp(Employee employee){
        int result = employeeMapper.insertSelective(employee);
        return result;
    }

    public Integer deleteEmpByEid(String id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

}
