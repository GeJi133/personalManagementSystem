package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.csu.personalManagementSystem.persistence.HandleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandleService {

    @Autowired
    HandleMapper handleMapper;

    public void handleLeaving(Leaving leaving){

        handleMapper.handleLeaving(leaving);
    }

    public void handleTransfer(Transfer transfer){
        handleMapper.handleTransfer(transfer);
    }

    public void handleJobTransfer(String id,String wantedJob){
        handleMapper.handleJobTransfer(id, wantedJob);
    }
}
