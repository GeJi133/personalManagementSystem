package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.*;
import org.csu.personalManagementSystem.persistence.AccountMapper;
import org.csu.personalManagementSystem.persistence.HandleMapper;
import org.csu.personalManagementSystem.persistence.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandleService {

    @Autowired
    HandleMapper handleMapper;

    @Autowired
    InformationMapper informationMapper;
    public void handleLeaving(Leaving leaving){

        handleMapper.handleLeaving1(leaving);
        handleMapper.handleLeaving2(leaving);
//        handleMapper.handleLeaving3(leaving);
//        handleMapper.handleLeaving4(leaving);
//        handleMapper.handleLeaving5(leaving);
    }

    public void handleDepartmentTransfer(DepartmentTransfer departmentTransfer){
        handleMapper.handleDepartmentTransfer1(departmentTransfer);
        handleMapper.handleDepartmentTransfer2(departmentTransfer);
    }

    public void handleJobTransfer(JobTransfer jobTransfer){
        handleMapper.handleJobTransfer1(jobTransfer);
        handleMapper.handleJobTransfer2(jobTransfer);
    }

    public void handlePositionTransfer(PositionTransfer positionTransfer){
        Employee employee=informationMapper.seeInformation(positionTransfer.getId());
        if(employee.getDepartment().equals("人力资源部")) {
            handleMapper.handlePositionTransfer12(positionTransfer);
            handleMapper.handlePositionTransfer2(positionTransfer);
        }
        else {
            handleMapper.handlePositionTransfer11(positionTransfer);
            handleMapper.handlePositionTransfer2(positionTransfer);
        }
    }

    public void handleNewEmployee(Employee employee){
        handleMapper.handleNewEmployee1(employee);
        handleMapper.handleNewEmployee2(employee);
        handleMapper.handleNewEmployee3(employee);
        handleMapper.handleNewEmployee4(employee);
        handleMapper.handleNewEmployee5(employee);
    }
}
