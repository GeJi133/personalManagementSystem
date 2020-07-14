package org.csu.personalManagementSystem.controller;


import org.csu.personalManagementSystem.domain.*;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/applications")        //applications是提出申请 包括离职申请 部门调动申请
public class ApplyController {
    @Autowired
    ApplyService applyService;
    @PostMapping(value = "/leavings",produces="application/Json;charset=UTF-8" )        //提出离职申请
    @ResponseBody
    public AppResult<String> insertLeaving(@RequestBody Leaving leaving){
        AppResult<String> appResult = new AppResult<>();
        applyService.insertLeaving(leaving);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/departmentTransfers",produces="application/Json;charset=UTF-8" )
    @ResponseBody
    public AppResult<String> insertDepartmentTransfer(@RequestBody DepartmentTransfer departmentTransfer){        //提出部门调动申请
        AppResult<String> appResult = new AppResult<>();
        applyService.insertDepartmentTransfer(departmentTransfer);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/jobTransfers",produces="application/Json;charset=UTF-8" )
    @ResponseBody
    public AppResult<String> insertJobTransfer(@RequestBody JobTransfer jobTransfer){        //提出岗位调动申请
        AppResult<String> appResult = new AppResult<>();
        applyService.insertJobTransfer(jobTransfer);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/positionTransfers",produces="application/Json;charset=UTF-8" )
    @ResponseBody
    public AppResult<String> insertJobTransfer(@RequestBody PositionTransfer positionTransfer){        //提出转正申请
        AppResult<String> appResult = new AppResult<>();
        applyService.insertPositionTransfer(positionTransfer);
        appResult= ResultBuilder.successNoData(ResultCode.Handled);
        return appResult;
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/leavings",produces="application/Json;charset=UTF-8")
    @ResponseBody
    public AppResult<ArrayList<Leaving>> seeLeavingApplications(){      //查看离职申请
        AppResult<ArrayList<Leaving>> appResult = new AppResult<>();
        ArrayList<Leaving> leavingArrayList=new ArrayList<>();
        leavingArrayList=applyService.seeLeavings();
        appResult=ResultBuilder.successData(ResultCode.OK,leavingArrayList);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/departmentTransfers",produces="application/Json;charset=UTF-8")
    @ResponseBody
    public AppResult<ArrayList<DepartmentTransfer>> seeDepartmentTransferApplications(){        //查看部门调动申请
        AppResult<ArrayList<DepartmentTransfer>> appResult = new AppResult<>();
        ArrayList<DepartmentTransfer> departmentTransferArrayList=new ArrayList<>();
        departmentTransferArrayList=applyService.seeDepartmentTransfers();
        appResult=ResultBuilder.successData(ResultCode.OK,departmentTransferArrayList);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/jobTransfers",produces="application/Json;charset=UTF-8")
    @ResponseBody
    public AppResult<ArrayList<JobTransfer>> seeJobTransferApplications(){      //查看岗位调动申请
        AppResult<ArrayList<JobTransfer>> appResult = new AppResult<>();
        ArrayList<JobTransfer> jobTransferArrayList=new ArrayList<>();
        jobTransferArrayList=applyService.seeJobTransfers();
        appResult=ResultBuilder.successData(ResultCode.OK,jobTransferArrayList);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/positionTransfers",produces="application/Json;charset=UTF-8")
    @ResponseBody
    public AppResult<ArrayList<PositionTransfer>> seePositionTransferApplications(){        //查看转正申请
        AppResult<ArrayList<PositionTransfer>> appResult = new AppResult<>();
        ArrayList<PositionTransfer> positionTransferArrayList=new ArrayList<>();
        positionTransferArrayList=applyService.seePositionTransfers();
        appResult=ResultBuilder.successData(ResultCode.OK,positionTransferArrayList);
        return appResult;
    }

}
