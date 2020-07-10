package org.csu.personalManagementSystem;

import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.domain.Employee;
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


    //测试模糊查询岗位名字
    @Test
    void TestGetJobByJob(){

            String string="人力";
            List<Job> list = jobService.getJobByJob(string);
            for (Object  obj:list
            ) {
                System.out.println(((Job)obj).getJob()+","+((Job)obj).getDescription());
            }

    }

    //测试查询岗位下属员工
    @Test
    void testGetAllEmployee(){

        String jno = "21"; // 21 是数据库中 人力专员的jno 编号
        List<Employee> list = jobService.getAllEmployee(jno);
        for (Employee obj:list
        ) {
            System.out.println(obj.getName() + "," + obj.getJobs());

        }
    }
    //测试新建岗位
    @Test
    void testInsertJob(){
        Job job = new Job("43","4","负责攻克技术难题","资深技术专员");
        jobService.insertJob(job);
    }

    //测试修改岗位
    @Test
    void testUpdateJob(){
        Job job = new Job("43","4","负责攻克技术难题,进行项目评估","资深技术专员");
        jobService.updateJob(job);
    }
}
