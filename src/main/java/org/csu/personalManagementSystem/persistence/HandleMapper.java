package org.csu.personalManagementSystem.persistence;


import org.csu.personalManagementSystem.domain.*;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleMapper {
    void handleLeaving1(Leaving leaving);
    void handleLeaving2(Leaving leaving);
    void handleDepartmentTransfer1(DepartmentTransfer departmentTransfer);
    void handleDepartmentTransfer2(DepartmentTransfer departmentTransfer);
    void handleJobTransfer1(JobTransfer jobTransfer);
    void handleJobTransfer2(JobTransfer jobTransfer);
    void handlePositionTransfer11(PositionTransfer positionTransfer);
    void handlePositionTransfer12(PositionTransfer positionTransfer);
    void handlePositionTransfer2(PositionTransfer positionTransfer);
    void handleNewEmployee1(Employee employee);
    void handleNewEmployee2(Employee employee);
}
