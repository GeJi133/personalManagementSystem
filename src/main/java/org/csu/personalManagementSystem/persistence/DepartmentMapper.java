package org.csu.personalManagementSystem.persistence;

import org.apache.ibatis.annotations.Param;
import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {

    //获取所有部门
    List<Department> getAll();

    //主要用于定位部门，可以定位的条件包括部门编号
    List<Department> getDepartmentByDno(String dno);

   //通过模糊查找获取相关的部门信息,部门名
    List<Department> getDepartmentByDepartment(@Param("department") String department);

    //通过模糊查找获取相关的部门信息,部门描述
    List<Department> getDepartmentByBusiness(@Param("business") String department);

    //主要用于查询指定部门当前在职员工信息
    List<Employee> getAllEmployee(String dno);

    //主要用于查询指定部门的岗位信息
    List<Job> getAllJob(String dno);

    //主要用于新建一个部门
    void insertDepartment(Department department);

    //主要用于修改已有部门的信息
    void updateDepartment(Department department);

    //主要用于删除一个部门
    void deleteDepartment(String dno);
}
