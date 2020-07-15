package org.csu.personalManagementSystem.controller;


import org.csu.personalManagementSystem.domain.*;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.persistence.ReportMapper;
import org.csu.personalManagementSystem.service.ReportService;
import org.csu.personalManagementSystem.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/reports")
@CrossOrigin
public class ReportController {
    @Autowired
    ReportService reportService;

    @Autowired
    SalaryService salaryService;
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

    //查询一段时间内指定部门的新聘员工信息
    @GetMapping(value = "/positionTransfer/{dno}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<PositionTransfer>> getAllPositionTransferByDnoAndTime(@PathVariable("dno") String dno,
                                                      @RequestParam(value = "startData", required = false) String startData,
                                                      @RequestParam(value = "endData", required = false) String endData){
        AppResult<List<PositionTransfer>> appResult = new AppResult<>();
        List<PositionTransfer> leavings = reportService.getAllPositionTransferByDnoAndTime(dno,startData,endData);
        appResult = ResultBuilder.successData(ResultCode.OK,leavings);

        return appResult;
    }
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

    //查询所有部门调动情况
    @GetMapping(value = "/departmentTransfers", produces = "application/Json;charset=UTF-8")
    public AppResult<List<DepartmentTransfer>> getTransfers(){
        AppResult<List<DepartmentTransfer>> appResult = new AppResult<>();
        List<DepartmentTransfer> transfers = reportService.getAllTransfer();
        appResult = ResultBuilder.successData(ResultCode.OK,transfers);

        return appResult;
    }
    //查询一段时间内岗位调动情况
    @GetMapping(value = "/departmentTransfers/time", produces = "application/Json;charset=UTF-8")
    public AppResult<List<DepartmentTransfer>> getLeavingsByTime(@RequestParam(value = "startData", required = false) String startData,
                                                      @RequestParam(value = "endData", required = false) String endData){
        AppResult<List<DepartmentTransfer>> appResult = new AppResult<>();
        List<DepartmentTransfer> transfers = reportService.getAllTransferByTime(startData,endData);
        appResult = ResultBuilder.successData(ResultCode.OK,transfers);

        return appResult;
    }

    //查询一段时间内调动情况
    @GetMapping(value = "/jobTransfers/time", produces = "application/Json;charset=UTF-8")
    public AppResult<List<JobTransfer>> getAllJobTransferByTime(@RequestParam(value = "startData", required = false) String startData,
                                                                 @RequestParam(value = "endData", required = false) String endData){
        AppResult<List<JobTransfer>> appResult = new AppResult<>();
        List<JobTransfer> transfers = reportService.getAllJobTransferByTime(startData,endData);
        appResult = ResultBuilder.successData(ResultCode.OK,transfers);

        return appResult;
    }
      /*
        人事月报
     */
    //按年月查询所有部门调动信息
      @GetMapping(value = "/departmentTransfers/month", produces = "application/Json;charset=UTF-8")
      public AppResult<List<DepartmentTransfer>> getAllTransferByMonth(@RequestParam(value = "year", required = false) String year,
                                                         @RequestParam(value = "month", required = false) String month){
          AppResult<List<DepartmentTransfer>> appResult = new AppResult<>();
          List<DepartmentTransfer> transfers = reportService.getAllTransferByMonth(year,month);
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

    //按年月查询所有部门调动信息
    @GetMapping(value = "/jobTransfers/month", produces = "application/Json;charset=UTF-8")
    public AppResult<List<JobTransfer>> getAlljobTransferByMonth(@RequestParam(value = "year", required = false) String year,
                                                                     @RequestParam(value = "month", required = false) String month){
        AppResult<List<JobTransfer>> appResult = new AppResult<>();
        List<JobTransfer> transfers = reportService.getAllJobTransferByTime(year,month);
        appResult = ResultBuilder.successData(ResultCode.OK,transfers);

        return appResult;
    }

    //按年月查询所有离职信息
    @GetMapping(value = "/positionTransfers/month", produces = "application/Json;charset=UTF-8")
    public AppResult<List<PositionTransfer>> getAllPositionTransferByMonth(@RequestParam(value = "year", required = false) String year,
                                                         @RequestParam(value = "month", required = false) String month){
        AppResult<List<PositionTransfer>> appResult = new AppResult<>();
        List<PositionTransfer> leavings = reportService.getAllPositionTransferByMonth(year,month);
        appResult = ResultBuilder.successData(ResultCode.OK,leavings);
        return appResult;
    }

    @GetMapping(value = "/achievements", produces = "application/Json;charset=UTF-8")
    public AppResult<Integer> getAchievementByTimeAndId(@RequestParam(value = "startData", required = false) String startData,
                                                                           @RequestParam(value = "endData", required = false) String endData,
                                                                           @RequestParam(value = "id") String id){
        AppResult<Integer> appResult = new AppResult<>();
        Integer sum=salaryService.getAchievementByDateAndId(startData,endData,id);
        appResult = ResultBuilder.successData(ResultCode.OK,sum);
        return appResult;
    }

    @GetMapping(value = "/attendances", produces = "application/Json;charset=UTF-8")
    public AppResult<float[]> getAttendanceByTimeAndId(@RequestParam(value = "startData", required = false) String startData,
                                                            @RequestParam(value = "endData", required = false) String endData,
                                                            @RequestParam(value = "id") String id){
        AppResult<float[]> appResult = new AppResult<>();
        float []result =salaryService.getAttendanceRateByDateAndId(startData,endData,id);
        appResult = ResultBuilder.successData(ResultCode.OK,result);
        return appResult;
    }
}
