package org.csu.personalManagementSystem;

import org.csu.personalManagementSystem.domain.Leaving;
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



    //查询一段时间内的离职信息
    @Test
    void testGetAllLeavingByTime(){
        String dno = "2";
        String startData = "2020-07-01";
        String endData = null;
        List<Leaving> leavings = reportService.getAllLeavingByDnoAndTime(dno,startData,endData);
        for (Leaving obj:leavings
             ) {
            System.out.println(obj.getId() + "  " + obj.getLeavingTime() + "    "+obj.getLeavingTime()+"    "+obj.getLeavingReason());

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
}
