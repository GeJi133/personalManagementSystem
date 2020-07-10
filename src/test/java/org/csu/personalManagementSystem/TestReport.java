package org.csu.personalManagementSystem;

import org.csu.personalManagementSystem.persistence.ReportMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("org.csu.personalManageSystem.persistence")
public class TestReport {

    @Autowired
    ReportMapper reportMapper;

    //测试获取所有辞职数据
    @Test
    void testGetAllLeaving(){
        reportMapper.getAllLeaving();
    }
}
