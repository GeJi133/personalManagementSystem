package org.csu.personalManagementSystem.persistence;


import org.csu.personalManagementSystem.domain.DepartmentTransfer;
import org.csu.personalManagementSystem.domain.JobTransfer;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.PositionTransfer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ApplyMapper {
    void insertLeaving(Leaving leaving);
    void insertDepartmentTransfer(DepartmentTransfer departmentTransfer);
    void insertJobTransfer(JobTransfer jobTransfer);
    void insertPositionTransfer(PositionTransfer positionTransfer);

    ArrayList<Leaving> seeLeavings();
    ArrayList<DepartmentTransfer> seeDepartmentTransfers();//查看部门调转申请
    ArrayList<JobTransfer> seeJobTransfers();//查看岗位调转申请
    ArrayList<PositionTransfer> seePositionTransfers();//查看转正申请


}
