package org.csu.personalManagementSystem.service;


import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.persistence.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InformationService {

    @Autowired
    InformationMapper informationMapper;
    public Employee seeInformationById(String id){
        return informationMapper.seeInformation(id);
    }

    public boolean updateInformationByEmployee(Employee employee){
        if(employee!=null){
            informationMapper.updateInformation(employee);
            return true;
        }
        else return false;
    }

    public ArrayList<Employee> seeAllEmployeesInformation(){
        return informationMapper.seeAllEmployeesInformation();
    }

    public ArrayList<Employee> seePracticeEmployeesInformation(){
        return informationMapper.seePracticeEmployeesInformation();
    }

    public ArrayList<Employee> seeFormalEmployeesInformation(){
        return informationMapper.seeFormalEmployeesInformation();
    }
}
