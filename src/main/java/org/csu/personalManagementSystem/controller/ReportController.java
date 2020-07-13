package org.csu.personalManagementSystem.controller;


import org.csu.personalManagementSystem.domain.*;
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
//
//    //查询离职情况
//    @GetMapping(value = "/leavings/{dno}", produces = "application/Json;charset=UTF-8")
//    public AppResult<List<Leaving>> getJobs(@PathVariable("dno") String dno){
//        AppResult<List<Leaving>> appResult = new AppResult<>();
//        List<Leaving> leavings = reportService.getAllLeavingByDno(dno);
//        appResult = ResultBuilder.successData(ResultCode.OK,leavings);
//        return appResult;
//    }


    //查询一段时间内指定部门的离职员工信息
    @GetMapping(value = "/leavings/{dno}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Leaving>> getLeavingsByTime(@PathVariable("dno") String dno,
                                                      @RequestParam(value = "startData", required = false) String startData,
                                                      @RequestParam(value = "endData", required = false) String endData){
        AppResult<List<Leaving>> appResult = new AppResult<>();
        List<Leaving> leavings = reportService.getAllLeavingByDnoAndTime(dno,startData,endData);
        appResult = ResultBuilder.successData(ResultCode.OK,leavings);

        return appResult;
    }

    //查询所有调动情况
    @GetMapping(value = "/transfers", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Transfer>> getTransfers(){
        AppResult<List<Transfer>> appResult = new AppResult<>();
        List<Transfer> transfers = reportService.getAllTransfer();
        appResult = ResultBuilder.successData(ResultCode.OK,transfers);

        return appResult;
    }
    //查询一段时间内调动情况
    @GetMapping(value = "/transfers/time", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Transfer>> getLeavingsByTime(@RequestParam(value = "startData", required = false) String startData,
                                                      @RequestParam(value = "endData", required = false) String endData){
        AppResult<List<Transfer>> appResult = new AppResult<>();
        List<Transfer> transfers = reportService.getAllTransferByTime(startData,endData);
        appResult = ResultBuilder.successData(ResultCode.OK,transfers);

        return appResult;
    }


      /*
        人事月报
     */
    //按年月查询所有调动信息
      @GetMapping(value = "/transfers/month", produces = "application/Json;charset=UTF-8")
      public AppResult<List<Transfer>> getAllTransferByMonth(@RequestParam(value = "year", required = false) String year,
                                                         @RequestParam(value = "month", required = false) String month){
          AppResult<List<Transfer>> appResult = new AppResult<>();
          List<Transfer> transfers = reportService.getAllTransferByMonth(year,month);
          appResult = ResultBuilder.successData(ResultCode.OK,transfers);

          return appResult;
      }

    //按年月查询所有离职信息
    @GetMapping(value = "/leavings/month", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Leaving>> getAllLeavingByMonth(@RequestParam(value = "year", required = false) String year,
                                                           @RequestParam(value = "month", required = false) String month){
        AppResult<List<Leaving>> appResult = new AppResult<>();
        List<Leaving> leavings = reportService.getAllLeavingByMonth(year,month);
        appResult = ResultBuilder.successData(ResultCode.OK,leavings);
        return appResult;
    }
}
