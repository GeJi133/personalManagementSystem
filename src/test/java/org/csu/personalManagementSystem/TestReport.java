package org.csu.personalManagementSystem;

import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.DepartmentTransfer;
import org.csu.personalManagementSystem.domain.PositionTransfer;
import org.csu.personalManagementSystem.persistence.ReportMapper;
import org.csu.personalManagementSystem.service.ReportService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.personalManageSystem.persistence")
public class TestReport {

    @Autowired
    ReportService reportService;

    //测试获取所有辞职数据
    @Test
    void testGetAllLeaving(){
        reportService.getAllLeaving();
    }



    //查询一段时间内指定部门的离职员工信息
    @Test
    void testGetAllLeavingByTime(){
        String dno = "2";
        String startData = "2020-07-01";
        String endData = null;
        List<Leaving> leavings = reportService.getAllLeavingByDnoAndTime(dno,startData,endData);
        for (Leaving obj:leavings
             ) {
            System.out.println(obj.getId() + "  " + obj.getLeavingTime() + "    "+obj.getLeavingTime()+"    "+obj.getStatus());

        }

    }

    //查询一段时间内指定部门的离职员工信息
    @Test
    void testGetAllPositionTransferByDnoAndTime(){
        String dno = "2";
        String startData = "2020-07-01";
        String endData = null;
        List<PositionTransfer> leavings = reportService.getAllPositionTransferByDnoAndTime(dno,startData,endData);
        for (PositionTransfer obj:leavings
        ) {
            System.out.println(obj.getId() + "  " + obj.getTransferDate() + "    "+obj.getTransferReason()+"    "+obj.getStatus());

        }

    }

//    //查询一段时间内指定部门的离职员工信息
//    @Test
//    void testGetAllLeavingByDno(){
//        String dno = "2";
//        List<Leaving> leavings = reportService.getAllLeavingByDno(dno);
//        for (Leaving obj:leavings
//        ) {
//            System.out.println(obj.getId() + "  " + obj.getDepartment() + "    "+obj.getLeavingReason());
//
//        }
//    }

    //测试查询一段时间内部门调用信息
    @Test
    void testGetAllTransferByTime(){
        String startData = "2020-07-01";
        String endData = null;
        List<DepartmentTransfer> transfers = reportService.getAllTransferByTime(startData,endData);
        for (DepartmentTransfer obj:transfers
        ) {
            System.out.println(obj.getId() + "  " + obj.getDepartmentBefore() + "    "+obj.getStatus()+"    "+obj.getTransferTime());

        }

    }

    // 测试按年月查询所有调动信息
    @Test
    void testGetAllTransferByMonth(){
        String year = "2020";
        String month = null;
        List<DepartmentTransfer> transfers = reportService.getAllTransferByMonth(year,month);
        for (DepartmentTransfer obj:transfers
        ) {
            System.out.println(obj.getId() + "  " + obj.getDepartmentBefore() + "    "+obj.getDepartmentAfter()+"    "+obj.getTransferTime());

        }
    }

    // 测试按年月查询所有调动信息
    @Test
    void testGetAllLeavingByMonth(){
        String year = "2020";
        String month = null;
        List<Leaving> leavings = reportService.getAllLeavingByMonth(year,month);
        for (Leaving obj:leavings
        ) {
            System.out.println(obj.getId() + "  " + obj.getLeavingTime() + "    "+obj.getLeavingTime()+"    "+obj.getLeavingReason());

        }
    }
}


