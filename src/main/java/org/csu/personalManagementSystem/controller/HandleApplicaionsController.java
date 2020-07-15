package org.csu.personalManagementSystem.controller;


import org.csu.personalManagementSystem.domain.*;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/handles")     //处理员工申请
public class HandleApplicaionsController {

    @Autowired
    HandleService handleService;
    @PatchMapping(value = "/transformations/departments",produces="application/Json;charset=UTF-8" )        //处理部门调动申请
    @ResponseBody
    public AppResult<String> handleDepartmentTransformations(@RequestBody DepartmentTransfer departmentTransfer){
        AppResult<String> appResult = new AppResult<>();
        handleService.handleDepartmentTransfer(departmentTransfer);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PatchMapping(value = "/transformations/jobs",produces="application/Json;charset=UTF-8" )        //处理岗位调动申请
    @ResponseBody
    public AppResult<String> handleJobTransformations(@RequestBody JobTransfer jobTransfer){
        AppResult<String> appResult = new AppResult<>();
        handleService.handleJobTransfer(jobTransfer);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PatchMapping(value = "/transformations/position",produces="application/Json;charset=UTF-8" )        //处理岗位调动申请
    @ResponseBody
    public AppResult<String> handlePositionTransformations(@RequestBody PositionTransfer positionTransfer){
        AppResult<String> appResult = new AppResult<>();
        handleService.handlePositionTransfer(positionTransfer);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/leavings",produces="application/Json;charset=UTF-8" )
    @ResponseBody
    public AppResult<String> handleLeaving(@RequestBody Leaving leaving){
        AppResult<String> appResult = new AppResult<>();
        handleService.handleLeaving(leaving);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/newEmployee",produces="application/Json;charset=UTF-8" )
    @ResponseBody
    public AppResult<String> insertNewEmployee(@RequestBody Employee employee){        //入职管理
        AppResult<String> appResult = new AppResult<>();
        handleService.handleNewEmployee(employee);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }
}
