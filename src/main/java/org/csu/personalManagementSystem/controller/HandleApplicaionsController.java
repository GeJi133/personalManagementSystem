package org.csu.personalManagementSystem.controller;


import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/handles")     //处理员工申请
public class HandleApplicaionsController {

    @Autowired
    HandleService handleService;
    @PatchMapping(value = "/transformations/departments",produces="application/Json;charset=UTF-8" )        //处理部门调动申请
    @ResponseBody
    public AppResult<String> handleDepartmentTransformations(@RequestBody Transfer transfer){
        AppResult<String> appResult = new AppResult<>();
        handleService.handleTransfer(transfer);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @PatchMapping(value = "/transformations/jobs",produces="application/Json;charset=UTF-8" )        //处理岗位调动申请
    @ResponseBody
    public AppResult<String> handleJobTransformations(@RequestParam String id,@RequestParam String wantedJob){
        AppResult<String> appResult = new AppResult<>();
        handleService.handleJobTransfer(id,wantedJob);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }


    @DeleteMapping(value = "/leavings",produces="application/Json;charset=UTF-8" )
    @ResponseBody
    public AppResult<String> handleLeaving(@RequestBody Leaving leaving){
        AppResult<String> appResult = new AppResult<>();
        handleService.handleLeaving(leaving);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }
}
