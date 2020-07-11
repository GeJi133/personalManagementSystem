package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Job;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.csu.personalManagementSystem.persistence.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportMapper  ReportMapper;

    //获取所有离职情况
    public List<Leaving> getAllLeaving() {
        return ReportMapper.getAllLeaving();
    }

//    //查询一段时间内指定部门的离职员工信息
//    public List<Leaving> getAllLeavingByDno(String Dno){
//        return ReportMapper.getAllLeavingByDno(Dno);
//    }

    //获取所有调动情况
    public List<Transfer> getAllTransfer(){
        return ReportMapper.getAllTransfer();
    }

    //查询一段时间内的离职信息
    public List<Leaving>   getAllLeavingByDnoAndTime(String dno,String startData,String endData){
        return ReportMapper.getAllLeavingByDnoAndTime(dno,startData,endData);
    }
    //查询一段时间内的所有调动信息
    public  List<Transfer> getAllTransferByTime(String startData,String endData) {
        return ReportMapper.getAllTransferByTime(startData,endData);
    }
}
