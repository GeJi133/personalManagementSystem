package org.csu.personalManagementSystem.persistence;


import org.csu.personalManagementSystem.domain.JobTransfer;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.DepartmentTransfer;
import org.csu.personalManagementSystem.domain.PositionTransfer;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleMapper {
    void handleLeaving1(Leaving leaving);
    void handleLeaving2(Leaving leaving);
    void handleDepartmentTransfer1(DepartmentTransfer departmentTransfer);
    void handleDepartmentTransfer2(DepartmentTransfer departmentTransfer);
    void handleJobTransfer1(JobTransfer jobTransfer);
    void handleJobTransfer2(JobTransfer jobTransfer);
    void handlePositionTransfer1(PositionTransfer positionTransfer);
    void handlePositionTransfer2(PositionTransfer positionTransfer);
}
