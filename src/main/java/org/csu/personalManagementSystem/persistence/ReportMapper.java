package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {

    //查询全部离职信息
    List<Leaving> getAllLeaving();

//    //查询一段时间内指定部门的离职员工信息
//    List<Leaving> getAllLeavingByDno(String Dno);

    //查询全部调动信息
    List<Transfer> getAllTransfer();

    //查询一段时间内的所有调动信息
    List<Transfer>   getAllTransferByTime(String startData,String endData);

    //查询一段时间内指定部门的离职员工信息
    List<Leaving>   getAllLeavingByDnoAndTime(String dno, String startData,String endData);

    //查询一段时间内指定部门的的新聘员工
    //查询一段时间内指定部门的离职员工信息
}
