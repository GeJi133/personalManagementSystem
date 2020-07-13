package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.Job;
import org.csu.personalManagementSystem.persistence.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobMapper JobMapper;

    //获取所有岗位
    public List<Job> getAll() {
        return JobMapper.getAll();
    }

    //主要用于定位岗位，可以定位的条件包括岗位编号
    public  List<Job>  getJobByDno(String jno){

        return JobMapper.getJobByDno(jno);
    }

    //通过模糊查找获取相关的岗位信息,岗位名
    public List<Job> getJobByJob(String Job){
        return JobMapper.getJobByJob(Job);
    }

    //通过模糊查找获取相关的岗位信息,岗位描述
    public List<Job> getJobByDescription(String description){
        return JobMapper.getJobByDescription(description);
    }

    //主要用于查询指定岗位当前在职员工信息
    public List<Employee> getAllEmployee(String jno){

        return JobMapper.getAllEmployee(jno);
    }


    //主要用于新建一个岗位
    public void insertJob(Job Job) {
        JobMapper.insertJob(Job);
       
    }

    //主要用于删除一个岗位
    public void deleteJob(String jno) {
        JobMapper.deleteJob(jno);
  
    }

    ////主要用于更新一个岗位
    public void updateJob(Job Job) {
        JobMapper.updateJob(Job);
    }
}
