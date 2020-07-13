package org.csu.personalManagementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.RespBean;
import org.csu.personalManagementSystem.domain.Salary;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.EmployeeLanguageService;
import org.csu.personalManagementSystem.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/salary")
@CrossOrigin
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping("/page")
    public String getAllSalaryByPage(Model model, @RequestParam(defaultValue = "1", required = true, value = "pageNum")Integer pageNum){
        Integer pageSize = 8;
        PageHelper.startPage(pageNum,pageSize);
        List<Salary> salary = salaryService.getSalaryByPage();
        PageInfo<Salary> pageInfo = new PageInfo<>(salary);
        model.addAttribute("salary", salary);
        model.addAttribute("pageInfo", pageInfo);
        return "allSalary";
    }


    @GetMapping(value = "/", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Salary>> getAllSalary(){
        AppResult<List<Salary>> appResult = new AppResult<>();
        List<Salary> salary = salaryService.getAllSalary ();
        appResult = ResultBuilder.successData(ResultCode.OK,salary);
        return appResult;
    }

    @GetMapping(value = "/{message}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Salary>>  viewJob(@PathVariable("message") String message,
                                         @RequestParam(value = "type", required = false) String type ){
        AppResult<List<Salary>> appResult = new AppResult<>();
        if(type.equals("id")){

            List<Salary> salary = salaryService.getSalaryById (message);
            appResult = ResultBuilder.successData(ResultCode.OK,salary);
        }

        else if(type.equals("name")){
            List<Salary> salary = salaryService.getSalaryByName (message);
            appResult = ResultBuilder.successData(ResultCode.OK,salary);
        }

        else appResult = ResultBuilder.fail(ResultCode.BadRequest);

        return appResult;
    }

    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary) {
        if (salaryService.updateSalary(salary) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}

