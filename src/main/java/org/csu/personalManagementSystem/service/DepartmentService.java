package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.persistence.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
   DepartmentMapper DepartmentMapper;

    //获取所有部门
    public List<Department> getAll() {
        return DepartmentMapper.getAll();
    }

    //主要用于定位部门，可以定位的条件包括部门编号
    public  Department getDepartmentByDno(String Dno){

        return DepartmentMapper.getDepartmentByDno(Dno);
    }

    //通过模糊查找获取相关的部门信息,部门名
    public List<Department> getDepartmentByDepartment(String department){

        return DepartmentMapper.getDepartmentByDepartment(department);
    }

    //查询部门下属员工,还未实现

    //主要用于新建一个部门
    public void insertDep(Department department) {
        DepartmentMapper.insertDepartment(department);

    }

    //主要用于删除一个部门
    public void deleteDep(String dno) {
        DepartmentMapper.deleteDepartment(dno);

    }

    ////主要用于更新一个部门
    public void updateDep(Department department) {
        DepartmentMapper.updateDepartment(department);

    }
}
