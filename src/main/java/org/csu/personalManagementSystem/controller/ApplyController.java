package org.csu.personalManagementSystem.controller;


import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/applications")        //applications是提出申请 包括离职申请 部门调动申请
public class ApplyController {
    @Autowired
    ApplyService applyService;
    @PostMapping(value = "/leavings",produces="application/Json;charset=UTF-8" )        //离职申请
    @ResponseBody
    public AppResult<String> insertLeaving(@RequestBody Leaving leaving){
        AppResult<String> appResult = new AppResult<>();
        applyService.insertLeaving(leaving);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @PostMapping(value = "/transfers",produces="application/Json;charset=UTF-8" )
    @ResponseBody
    public AppResult<String> insertTransfer(@RequestBody Transfer transfer){        //部门调动申请
        AppResult<String> appResult = new AppResult<>();
        applyService.insertTransfer(transfer);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @GetMapping(value = "/leavings",produces="application/Json;charset=UTF-8")
    @ResponseBody
    public AppResult<ArrayList<Leaving>> seeLeavingApplications(){
        AppResult<ArrayList<Leaving>> appResult = new AppResult<>();
        ArrayList<Leaving> leavingArrayList=new ArrayList<>();
        leavingArrayList=applyService.seeLeavings();
        appResult=ResultBuilder.successData(ResultCode.OK,leavingArrayList);
        return appResult;
    }

    @GetMapping(value = "/transfers",produces="application/Json;charset=UTF-8")
    @ResponseBody
    public AppResult<ArrayList<Transfer>> seeTransferApplications(){
        AppResult<ArrayList<Transfer>> appResult = new AppResult<>();
        ArrayList<Transfer> leavingArrayList=new ArrayList<>();
        leavingArrayList=applyService.seeTransfers();
        appResult=ResultBuilder.successData(ResultCode.OK,leavingArrayList);
        return appResult;
    }
}
