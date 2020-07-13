package org.csu.personalManagementSystem.service;

<<<<<<< HEAD
import org.csu.personalManagementSystem.domain.DepartmentTransfer;
import org.csu.personalManagementSystem.domain.JobTransfer;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.PositionTransfer;
=======
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
>>>>>>> ba94bb41b27c1c0049548d36772fe8177d87911f
import org.csu.personalManagementSystem.persistence.HandleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandleService {

    @Autowired
    HandleMapper handleMapper;

    public void handleLeaving(Leaving leaving){

<<<<<<< HEAD
        handleMapper.handleLeaving1(leaving);
        handleMapper.handleLeaving2(leaving);
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
        handleMapper.handlePositionTransfer1(positionTransfer);
        handleMapper.handlePositionTransfer2(positionTransfer);
=======
        handleMapper.handleLeaving(leaving);
    }

    public void handleTransfer(Transfer transfer){
        handleMapper.handleTransfer(transfer);
    }

    public void handleJobTransfer(String id,String wantedJob){
        handleMapper.handleJobTransfer(id, wantedJob);
>>>>>>> ba94bb41b27c1c0049548d36772fe8177d87911f
    }

}
