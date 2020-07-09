package org.csu.personalManagementSystem;

import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.domain.Job;
import org.csu.personalManagementSystem.service.JobService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.personalManageSystem.persistence")
public class TestJob {
    @Autowired
    JobService jobService;

    @Test
    void TestGetJobByJob(){

            String string="人力";
            List<Job> list = jobService.getJobByJob(string);
            for (Object  obj:list
            ) {
                System.out.println(((Job)obj).getJob()+","+((Job)obj).getDescription());
            }

    }
}
