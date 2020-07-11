package org.csu.personalManagementSystem.controller;


import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.persistence.ReportMapper;
import org.csu.personalManagementSystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/reports")
@CrossOrigin
public class ReportController {
    @Autowired
    ReportService reportService;

    //查询离职情况
    @GetMapping(value = "/leavings", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Leaving>> getLeavings(){
        AppResult<List<Leaving>> appResult = new AppResult<>();
        List<Leaving> leavings = reportService.getAllLeaving();
        appResult = ResultBuilder.successData(ResultCode.OK,leavings);

        return appResult;
    }


    //查询一段时间内的离职情况
    @GetMapping(value = "/leavings/time", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Leaving>> getLeavingsByTime(@RequestParam(value = "startData", required = false) String startData,
                                                @RequestParam(value = "endData", required = false) String endData){
        AppResult<List<Leaving>> appResult = new AppResult<>();
        List<Leaving> leavings = reportService.getAllLeavingByTime(startData,endData);
        appResult = ResultBuilder.successData(ResultCode.OK,leavings);

        return appResult;
    }

    //查询所有调动情况
    @GetMapping(value = "/transfers", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Transfer>> getTransfers(){
        AppResult<List<Transfer>> appResult = new AppResult<>();
        List<Transfer> leavings = reportService.getAllTransfer();
        appResult = ResultBuilder.successData(ResultCode.OK,leavings);

        return appResult;
    }
}
