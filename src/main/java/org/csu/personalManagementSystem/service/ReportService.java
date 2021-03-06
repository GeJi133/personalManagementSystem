package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.*;
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
    public List<DepartmentTransfer> getAllTransfer(){
        return ReportMapper.getAllTransfer();
    }

    //查询一段时间内 指定部门的离职信息
    public List<Leaving>   getAllLeavingByDnoAndTime(String dno,String startData,String endData){
        return ReportMapper.getAllLeavingByDnoAndTime(dno,startData,endData);
    }

    //查询一段时间内 指定部门的离职信息
    public List<PositionTransfer>   getAllPositionTransferByDnoAndTime(String dno, String startData, String endData){
        return ReportMapper.getAllPositionTransferByDnoAndTime(dno,startData,endData);
    }
    //查询一段时间内的所有部门调动信息
    public  List<DepartmentTransfer> getAllTransferByTime(String startData,String endData) {
        return ReportMapper.getAllTransferByTime(startData,endData);
    }

    //查询一段时间内的所有岗位调动信息
    public  List<JobTransfer> getAllJobTransferByTime(String startData, String endData) {
        return ReportMapper.getAllJobTransferByTime(startData,endData);
    }
    /*
     人事月报
  */
    //按年月查询所有部门调动信息
    public List<DepartmentTransfer> getAllTransferByMonth(String year,String month){
        return ReportMapper.getAllTransferByMonth(year,month);
    }

    //按年月查询所有离职信息
    public List<Leaving> getAllLeavingByMonth(String year,String month){
        return ReportMapper.getAllLeavingByMonth(year,month);
    }

    //按年月查询所有岗位调动信息
    public List<JobTransfer> getAllJobTransferByMonth(String year,String month){
        return ReportMapper.getAllJobTransferByMonth(year,month);
    }

    //按年月查询所有离职信息
    public List<PositionTransfer> getAllPositionTransferByMonth(String year,String month){
        return ReportMapper.getAllPositionTransferByMonth(year,month);
    }

}
