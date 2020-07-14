package org.csu.personalManagementSystem.controller;
import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("/information")
@CrossOrigin
public class InformationController {

    @Autowired
    InformationService informationService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/id/{id}",produces="application/Json;charset=UTF-8" )  //员工查看个人信息
    public AppResult<Employee> seeMyInformation(@PathVariable("id") String id){
        Employee employee=informationService.seeInformationById(id);
        AppResult<Employee> appResult=new AppResult<>();
        if(employee!=null)
        appResult= ResultBuilder.successData(ResultCode.OK,employee);
        else  appResult=ResultBuilder.fail(ResultCode.NoInfoFind);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/all",produces="application/Json;charset=UTF-8" )     //管理员查看所有员工信息
    public AppResult<ArrayList<Employee>> seeAllEmployeesInformation(){
        ArrayList employeeArrayList=new ArrayList<>();
        employeeArrayList=informationService.seeAllEmployeesInformation();
        AppResult<ArrayList<Employee>> appResult=new AppResult<>();
        appResult= ResultBuilder.successData(ResultCode.OK,employeeArrayList);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/practice",produces="application/Json;charset=UTF-8" )     //管理员查看所有试用期员工信息
    public AppResult<ArrayList<Employee>> seePracticeEmployeesInformation(){
        ArrayList employeeArrayList=new ArrayList<>();
        employeeArrayList=informationService.seePracticeEmployeesInformation();
        AppResult<ArrayList<Employee>> appResult=new AppResult<>();
        appResult= ResultBuilder.successData(ResultCode.OK,employeeArrayList);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/formal",produces="application/Json;charset=UTF-8" )     //管理员查看所有正式员工信息
    public AppResult<ArrayList<Employee>> seeFormalEmployeesInformation(){
        ArrayList employeeArrayList=new ArrayList<>();
        employeeArrayList=informationService.seeFormalEmployeesInformation();
        AppResult<ArrayList<Employee>> appResult=new AppResult<>();
        appResult= ResultBuilder.successData(ResultCode.OK,employeeArrayList);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PatchMapping(value = "id/{id}",produces = "application/Json;charset=UTF-8")
    public AppResult<String> updateInformation(@RequestBody Employee employee){
        AppResult<String> appResult=new AppResult<>();
        if(informationService.updateInformationByEmployee(employee)){
            appResult= ResultBuilder.successNoData(ResultCode.Handled);
        }
        else appResult=ResultBuilder.fail(ResultCode.BadRequest);
        return appResult;
    }


}
