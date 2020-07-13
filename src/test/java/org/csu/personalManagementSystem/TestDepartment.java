package org.csu.personalManagementSystem;

import org.csu.personalManagementSystem.domain.Department;
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


    @Test
    void testGetAll(){

        List<Department> list =departmentService.getAll();
        for (Department  obj:list
        ) {
            System.out.println("dno:"+obj.getDno()+"    department:"+obj.getDepartment()+"   business:"+obj.getBusiness());
        }
    }
    @Test
    void testGetDepartmentByDepartment() {

        String string="资源";
        List<Department> list = departmentService.getDepartmentByDepartment(string);
        for (Object  obj:list
             ) {
            System.out.println(((Department)obj).getDepartment());
        }
    }

    @Test
    void testInsertDep(){
        Department department = new Department("6","商务部","负责与客户的接待与联络工作");
        departmentService.insertDep(department);
    }

    @Test
    void testDeleteDep(){
        departmentService.deleteDep("6");
    }
}
