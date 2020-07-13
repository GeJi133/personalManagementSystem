package org.csu.personalManagementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.RespBean;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.EmployeeLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/language")
@CrossOrigin
public class EmployeeLanguageController {
    @Autowired

    private EmployeeLanguageService employeeLanguageService;

    @GetMapping("/page")
    public String getAllEmployeeLanguageByPage(Model model, @RequestParam(defaultValue = "1", required = true, value = "pageNum")Integer pageNum){
        Integer pageSize = 8;
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> employee = employeeLanguageService.getEmployeeLanguageByPage();
        PageInfo<Employee> pageInfo = new PageInfo<>(employee);
        model.addAttribute("employee", employee);
        model.addAttribute("pageInfo", pageInfo);
        return "allEmployeeLanguageByPage";
    }

    @GetMapping(value = "/", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Employee>> getAllEmployeeLanguage(){
        AppResult<List<Employee>> appResult = new AppResult<>();
        List<Employee> employee = employeeLanguageService.getAllEmployeeLanguage ();
        appResult = ResultBuilder.successData(ResultCode.OK,employee);
        return appResult;
    }

    @GetMapping(value = "/{message}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Employee>>  viewJob(@PathVariable("message") String message,
                                              @RequestParam(value = "type", required = false) String type ){
        AppResult<List<Employee>> appResult = new AppResult<>();
        if(type.equals("id")){

            List<Employee> employee = employeeLanguageService.getEmployeeLanguageById (message);
            appResult = ResultBuilder.successData(ResultCode.OK,employee);
        }

        else if(type.equals("name")){
            List<Employee> employee = employeeLanguageService.getEmployeeLanguageByName (message);
            appResult = ResultBuilder.successData(ResultCode.OK,employee);
        }

        else appResult = ResultBuilder.fail(ResultCode.BadRequest);

        return appResult;
    }

    @PostMapping("/")

    public RespBean addEmpLanguage(@RequestBody Employee employee) {
        if (employeeLanguageService.addEmpLanguage(employee) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpLanguageByid(@PathVariable("id") String id) {
        if (employeeLanguageService.deleteEmpLanguageByid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    public RespBean updateEmpLanguage(@RequestBody Employee employee) {
        if (employeeLanguageService.updateEmpLanguage(employee) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
