package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.csu.personalManagementSystem.persistence.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
