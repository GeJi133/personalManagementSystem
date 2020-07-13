package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.JobTransfer;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.DepartmentTransfer;
import org.csu.personalManagementSystem.domain.PositionTransfer;
import org.csu.personalManagementSystem.persistence.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApplyService {

    @Autowired
    ApplyMapper applyMapper;
    public void insertLeaving(Leaving leaving){
        applyMapper.insertLeaving(leaving);
    }

    public void insertDepartmentTransfer(DepartmentTransfer departmentTransfer){
        applyMapper.insertDepartmentTransfer(departmentTransfer);
    }

    public void insertJobTransfer(JobTransfer jobTransfer){
        applyMapper.insertJobTransfer(jobTransfer);
    }

    public void insertPositionTransfer(PositionTransfer positionTransfer){
        applyMapper.insertPositionTransfer(positionTransfer);
    }

    public ArrayList<Leaving> seeLeavings(){
        ArrayList<Leaving> leavingList=new ArrayList<>();
        leavingList=applyMapper.seeLeavings();
        return leavingList;
    }

    public ArrayList<DepartmentTransfer> seeDepartmentTransfers(){
        ArrayList<DepartmentTransfer> departmentTransferList =new ArrayList<>();
        departmentTransferList =applyMapper.seeDepartmentTransfers();
        return departmentTransferList;
    }

    public ArrayList<JobTransfer> seeJobTransfers(){
        ArrayList<JobTransfer> jobTransferArrayList=new ArrayList<>();
        jobTransferArrayList =applyMapper.seeJobTransfers();
        return jobTransferArrayList;
    }

    public ArrayList<PositionTransfer> seePositionTransfers(){
        ArrayList<PositionTransfer> positionTransferArrayList= new ArrayList<>();
        positionTransferArrayList =applyMapper.seePositionTransfers();
        return positionTransferArrayList;
    }
}
