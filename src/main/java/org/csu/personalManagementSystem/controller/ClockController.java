package org.csu.personalManagementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.personalManagementSystem.domain.*;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.EmployeeLanguageService;
import org.csu.personalManagementSystem.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/clock")
@CrossOrigin
public class ClockController {
    @Autowired
    private ClockService clockService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/page")
    public String getAllClockByPage(Model model, @RequestParam(defaultValue = "1", required = true, value = "pageNum")Integer pageNum){
        Integer pageSize = 8;
        PageHelper.startPage(pageNum,pageSize);
        List<Clock> clock = clockService.getClockByPage();
        PageInfo<Clock> pageInfo = new PageInfo<>(clock);
        model.addAttribute("clock", clock);
        model.addAttribute("pageInfo", pageInfo);
        return "allClock";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Clock>> getAllClock(){
        AppResult<List<Clock>> appResult = new AppResult<>();
        List<Clock> clock = clockService.getAllClock ();
        appResult = ResultBuilder.successData(ResultCode.OK,clock);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/{message}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Clock>>  viewJob(@PathVariable("message") String message,
                                            @RequestParam(value = "type", required = false) String type ){
        AppResult<List<Clock>> appResult = new AppResult<>();
        if(type.equals("id")){

            List<Clock> clock = clockService.getClockById (message);
            appResult = ResultBuilder.successData(ResultCode.OK,clock);
        }

        else if(type.equals("name")){
            List<Clock> clock = clockService.getClockByName (message);
            appResult = ResultBuilder.successData(ResultCode.OK,clock);
        }

        else appResult = ResultBuilder.fail(ResultCode.BadRequest);
        return appResult;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/")
    public RespBean updateClock(@RequestBody  Clock clock) {
        if (clockService.updateClock(clock) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}

