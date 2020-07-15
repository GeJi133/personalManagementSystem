package org.csu.personalManagementSystem.controller;

import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.Job;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/departments")
@CrossOrigin
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    //查询所有部门
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE','TRAINEE')")
    @GetMapping(value = "/", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Department>> getDepartments(){
        AppResult<List<Department>> appResult = new AppResult<>();
        List<Department> departments = departmentService.getAll ();
        appResult = ResultBuilder.successData(ResultCode.OK,departments);
        return appResult;
    }


    //查询部门（条件查询，type = dno，根据部门编号查询， type = department ，根据部门名称模糊查询）
//    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE','TRAINEE')")
    @GetMapping(value = "/{message}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Department>>  viewDepartment(@PathVariable("message") String message,
                                                @RequestParam(value = "type", required = false) String type ){
        AppResult<List<Department>> appResult = new AppResult<>();
        if(type.equals("dno")){

            List<Department> departments = departmentService.getDepartmentByDno (message);
            appResult = ResultBuilder.successData(ResultCode.OK,departments);
        }

        else if(type.equals("department")){

            List<Department> departments = departmentService.getDepartmentByDepartment (message);
            appResult = ResultBuilder.successData(ResultCode.OK,departments);
        }

        else if(type.equals("business")){
            List<Department> departments = departmentService.getDepartmentByBusiness (message);
            appResult = ResultBuilder.successData(ResultCode.OK,departments);
        }

        else appResult = ResultBuilder.fail(ResultCode.BadRequest);

        return appResult;
    }

  /*  @GetMapping(value = "/{department}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Department>> viewDepartmentByDepartment(@PathVariable("department") String department){
        AppResult<List<Department>>appResult = new AppResult<>();
        List<Department> departments = departmentService.getDepartmentByDepartment (department);
        appResult = ResultBuilder.successData(ResultCode.OK,departments);

        return appResult;
    }*/


    //主要用于查询指定部门当前在职员工信息
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/employees/{dno}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Employee>> getEmployees(@PathVariable("dno") String dno){
        AppResult<List<Employee>> appResult = new AppResult<>();
        List<Employee> employees = departmentService.getAllEmployee(dno);
        appResult = ResultBuilder.successData(ResultCode.OK,employees);
        return appResult;
    }

    //主要用于查询指定部门的岗位信息
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/jobs/{dno}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Job>> getJobs(@PathVariable("dno") String dno){
        AppResult<List<Job>> appResult = new AppResult<>();
        List<Job> jobs = departmentService.getAllJob(dno);
        appResult = ResultBuilder.successData(ResultCode.OK,jobs);
        return appResult;
    }


    //新增一个部门
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/",produces="application/Json;charset=UTF-8")
    @ResponseBody
    public AppResult<String> insertDepartment(@RequestBody Department department){
        AppResult<String> appResult = new AppResult<>();
        departmentService.insertDep(department);
        appResult = ResultBuilder.successNoData(ResultCode.Handled);

        return appResult;
    }

    //修改部门
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/",produces="application/Json;charset=UTF-8")
    public AppResult<String> updateDepartment(@RequestBody Department department){
        AppResult<String> appResult = new AppResult<>();
        departmentService.updateDep(department);
        appResult = ResultBuilder.successNoData(ResultCode.Handled);

        return appResult;
    }

    //删除部门
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/",produces="application/Json;charset=UTF-8")
    public AppResult<String> deleteDepartment(@RequestBody String dno){
        AppResult<String> appResult = new AppResult<>();
        departmentService.deleteDep(dno);
        appResult = ResultBuilder.successNoData(ResultCode.Handled);

        return appResult;
    }

}

