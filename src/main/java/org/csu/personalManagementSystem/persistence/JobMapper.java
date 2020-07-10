package org.csu.personalManagementSystem.persistence;

import org.apache.ibatis.annotations.Param;
import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.domain.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobMapper {

    //获取所有岗位
    List<Job> getAll();

    //主要用于定位岗位，可以定位的条件包括岗位编号
    List<Job> getJobByDno(String jno);

    //通过模糊查找获取相关的岗位信息,岗位名
    List<Job> getJobByJob(@Param("job") String job);

    //通过模糊查找获取相关的岗位信息,岗位名
    List<Job> getDepartmentByDescription(@Param("description") String description);

    //查询岗位下属员工,还未实现


    //主要用于新建一个岗位
    void insertJob(Job job);

    //主要用于修改已有岗位的信息
    void updateJob(Job job);

    //主要用于删除一个岗位
    void deleteJob(String jno);
}
