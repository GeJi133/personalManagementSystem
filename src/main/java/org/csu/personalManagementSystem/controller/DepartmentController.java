package org.csu.personalManagementSystem.controller;

import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.domain.Job;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.DepartmentService;
import org.csu.personalManagementSystem.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/departments")
@CrossOrigin
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    JobService jobService;
    @GetMapping(value = "/", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Department>> getDepartments(){
        AppResult<List<Department>> appResult = new AppResult<>();
        List<Department> departments = departmentService.getAll ();
        appResult = ResultBuilder.successData(ResultCode.OK,departments);
        return appResult;
    }


    @GetMapping(value = "/{dno}", produces = "application/Json;charset=UTF-8")
    public AppResult<Department> viewDepartment(@PathVariable("dno") String dno){
        AppResult<Department> appResult = new AppResult<>();
        Department department = departmentService.getDepartmentByDno (dno);
        appResult = ResultBuilder.successData(ResultCode.OK,department);

        return appResult;
    }

    @GetMapping(value = "/{dno}/jobs", produces="application/Json;charset=UTF-8" )
    public AppResult<List<Job>> viewjob(@PathVariable("dno") String dno){
        AppResult<List<Department>> appResult = new AppResult<>();

       List<Job> jobs = ;

            appResult = ResultBuilder.successData(ResultCode.OK,jobs);

        return appResult;
    }

}
