package org.csu.personalManagementSystem.controller;

import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Department;
import org.csu.personalManagementSystem.domain.Job;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/jobs")
@CrossOrigin
public class JobController {
    @Autowired
    JobService jobService;


    //查询所有岗位
    @GetMapping(value = "/", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Job>> getJobs(){
        AppResult<List<Job>> appResult = new AppResult<>();
        List<Job> jobs = jobService.getAll ();
        appResult = ResultBuilder.successData(ResultCode.OK,jobs);
        return appResult;
    }

//    //查询岗位，通过jno(岗位编号)
//    @GetMapping(value = "/{jno}", produces = "application/Json;charset=UTF-8")
//    public AppResult<Job> viewJob(@PathVariable("jno") String jno){
//        AppResult<Job> appResult = new AppResult<>();
//        Job job = jobService.getJobByDno (jno);
//        appResult = ResultBuilder.successData(ResultCode.OK,job);
//
//        return appResult;
//    }
//
//    //查询岗位，模糊查询岗位名称
//    @GetMapping(value = "/{job}", produces = "application/Json;charset=UTF-8")
//    public AppResult<List<Job>> viewJobByJob(@PathVariable("job") String job){
//        AppResult<List<Job>>appResult = new AppResult<>();
//        List<Job> jobs = jobService.getJobByJob (job);
//        appResult = ResultBuilder.successData(ResultCode.OK,jobs);
//
//        return appResult;
//    }

    //查询岗位（条件查询，type = jno，根据岗位编号查询， type = job ，根据岗位名称模糊查询）
    @GetMapping(value = "/{message}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Job>>  viewJob(@PathVariable("message") String message,
                                         @RequestParam(value = "type", required = false) String type ){
        AppResult<List<Job>> appResult = new AppResult<>();
        if(type.equals("jno")){

            List<Job> jobs = jobService.getJobByDno (message);
            appResult = ResultBuilder.successData(ResultCode.OK,jobs);
        }

        else if(type.equals("job")){

            List<Job> jobs = jobService.getJobByJob (message);
            appResult = ResultBuilder.successData(ResultCode.OK,jobs);
        }

        else if(type.equals("description")){
            List<Job> jobs = jobService.getJobByDescription (message);
            appResult = ResultBuilder.successData(ResultCode.OK,jobs);
        }

        else appResult = ResultBuilder.fail(ResultCode.BadRequest);

        return appResult;
    }



    //新增一个岗位
    @PostMapping(value = "/",produces="application/Json;charset=UTF-8")
    @ResponseBody
    public AppResult<String> insertJob(@RequestBody Job job){
        AppResult<String> appResult = new AppResult<>();
        jobService.insertJob(job);
        appResult = ResultBuilder.successNoData(ResultCode.Handled);

        return appResult;
    }

    //修改岗位
    @PutMapping(value = "/",produces="application/Json;charset=UTF-8")
    public AppResult<String> updateJob(@RequestBody Job job){
        AppResult<String> appResult = new AppResult<>();
        jobService.updateJob(job);
        appResult = ResultBuilder.successNoData(ResultCode.Handled);

        return appResult;
    }

    //删除岗位
    @DeleteMapping(value = "/",produces="application/Json;charset=UTF-8")
    public AppResult<String> deleteJob(@RequestBody String jno){
        AppResult<String> appResult = new AppResult<>();
        jobService.deleteJob(jno);
        appResult = ResultBuilder.successNoData(ResultCode.Handled);

        return appResult;
    }

}

