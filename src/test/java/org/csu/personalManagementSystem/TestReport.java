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


    @Test
    //查询一段时间内的离职信息
    void testGetAllLeavingByTime(){
        String startData = "2020-07-02";
        String endData = null;
        List<Leaving> leavings = reportService.getAllLeavingByTime(startData,endData);
        for (Leaving obj:leavings
             ) {
            System.out.println(obj.getId() + "  " + obj.getLeavingTime() + "    "+obj.getLeavingReason());

        }

    }
}
