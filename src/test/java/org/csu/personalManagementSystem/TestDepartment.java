package org.csu.personalManagementSystem;

import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.Job;
import org.csu.personalManagementSystem.service.DepartmentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.personalManageSystem.persistence")
public class TestDepartment {
    @Autowired
    DepartmentService departmentService;

    //查询所有部门
    @Test
    void testGetAll(){

        List<Department> list =departmentService.getAll();
        for (Department  obj:list
        ) {
            System.out.println("dno:"+obj.getDno()+"    department:"+obj.getDepartment()+"   business:"+obj.getBusiness() + "   performance:" + obj.getPerformance());
        }
    }


    //查询部门编号
    @Test
    void testGetDepartmentByDno(){
        String string="1";
        List<Department> list = departmentService.getDepartmentByDno(string);
        for (Object  obj:list
        ) {
            System.out.println(((Department)obj).getDepartment());
        }
    }
    //测试模糊查询部门名字
    @Test
    void testGetDepartmentByDepartment() {

        String string="资源";
        List<Department> list = departmentService.getDepartmentByDepartment(string);
        for (Object  obj:list
             ) {
            System.out.println(((Department)obj).getDepartment());
        }
    }


    //测试模糊查询部门描述
    @Test
    void testGetDepartmentByBusiness() {

        String string="资源";
        List<Department> list = departmentService.getDepartmentByBusiness(string);
        for (Object  obj:list
        ) {
            System.out.println(((Department)obj).getDepartment());
        }
    }

    //测试查询部门下属员工,positon = 1 表示正式员工  = 2 表示 管理员
    @Test
    void testGetAllEmployee(){

        String dno = "1";
        List<Employee> list = departmentService.getAllEmployee(dno);
        for (Employee obj:list
             ) {
            System.out.println(obj.getName()+" , " + obj.getPosition());

        }
    }
    //测试查询部门下属岗位
    @Test
    void testGetAllJob(){
        String dno = "1";
        List<Job> list = departmentService.getAllJob(dno);
        for (Job obj:list
        ) {
            System.out.println(obj.getJno() + "," + obj.getDno() + "," + obj.getDescription() + " ," + obj.getJob());

        }
    }
    //测试新建部门
    @Test
    void testInsertDep(){
        Department department = new Department("6","商务部","负责与客户的接待与联络工作");
        departmentService.insertDep(department);
    }

    //测试删除部门
    @Test
    void testDeleteDep(){
        departmentService.deleteDep("6");
    }
}
