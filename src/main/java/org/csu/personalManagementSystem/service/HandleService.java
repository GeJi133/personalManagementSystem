package org.csu.personalManagementSystem.service;
import org.csu.personalManagementSystem.domain.DepartmentTransfer;
import org.csu.personalManagementSystem.domain.JobTransfer;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.PositionTransfer;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.DepartmentTransfer;
import org.csu.personalManagementSystem.persistence.HandleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HandleService {
    @Autowired
    HandleMapper handleMapper;
    public void handleLeaving(Leaving leaving){
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
    }
}
