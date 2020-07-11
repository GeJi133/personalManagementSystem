package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {

    //查询全部离职信息
    List<Leaving> getAllLeaving();

    //查询全部调动信息
    List<Transfer> getAllTransfer();

    //查询一段时间内的离职信息
    List<Leaving>   getAllLeavingByTime(String startData,String endData);

    //查询一段时间内的新聘员工
}
