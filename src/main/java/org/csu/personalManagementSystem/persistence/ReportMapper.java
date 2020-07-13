package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.JobTransfer;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.DepartmentTransfer;
import org.csu.personalManagementSystem.domain.PositionTransfer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {

    //查询全部离职信息
    List<Leaving> getAllLeaving();

//    //查询一段时间内指定部门的离职员工信息
//    List<Leaving> getAllLeavingByDno(String Dno);

    //查询全部调动信息
    List<DepartmentTransfer> getAllTransfer();

    //查询一段时间内的部门调动信息
    List<DepartmentTransfer>   getAllTransferByTime(String startData,String endData);

    //查询一段时间内指定部门的离职员工信息
    List<Leaving>   getAllLeavingByDnoAndTime(String dno, String startData,String endData);

    //查询一段时间内指定部门的的新聘员工
    List<PositionTransfer> getAllPositionTransferByDnoAndTime(String dno, String startData,String endData);

    //查询一段时间内的岗位调动信息
    List<JobTransfer>   getAllJobTransferByTime(String startData, String endData);


    //查询一段时间内指定部门的离职员工信息

    /*
        人事月报
     */
    //按年月查询所有部门调动信息
    List<DepartmentTransfer> getAllTransferByMonth(String year,String month);

    //按年月查询所有离职员工信息
    List<Leaving> getAllLeavingByMonth(String year,String month);


    //按年月查询所有岗位调动信息
    List<JobTransfer> getAllJobTransferByMonth(String year,String month);

    //按年月查询所有新聘员工信息
    List<PositionTransfer> getAllPositionTransferByMonth(String year,String month);

}
