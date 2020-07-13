package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.csu.personalManagementSystem.persistence.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplyService {

    @Autowired
    ApplyMapper applyMapper;
    public void insertLeaving(Leaving leaving){
        applyMapper.insertLeaving(leaving);
    }

    public void insertTransfer(Transfer transfer){
        applyMapper.insertTransfer(transfer);
    }

    public ArrayList<Leaving> seeLeavings(){
        ArrayList<Leaving> leavingList=new ArrayList<>();
        leavingList=applyMapper.seeLeavings();
        return leavingList;
    }

    public ArrayList<Transfer> seeTransfers(){
        ArrayList<Transfer> transferList=new ArrayList<>();
        transferList=applyMapper.seeTransfers();
        return transferList;
    }
}
