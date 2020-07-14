package org.csu.personalManagementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.RespBean;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.EmployeeCareerService;
import org.csu.personalManagementSystem.service.EmployeeLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/career")
@CrossOrigin
public class EmployeeCareerController {
    @Autowired

    private EmployeeCareerService employeeCareerService;

    @GetMapping("/page")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String getAllEmployeeCareerByPage(Model model, @RequestParam(defaultValue = "1", required = true, value = "pageNum")Integer pageNum){
        Integer pageSize = 8;
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> employee = employeeCareerService.getEmployeeCareerByPage();
        PageInfo<Employee> pageInfo = new PageInfo<>(employee);
        model.addAttribute("employee", employee);
        model.addAttribute("pageInfo", pageInfo);
        return "allEmployeeCareerByPage";
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/")

    public RespBean addEmpCareer(@RequestBody Employee employee) {
        if (employeeCareerService.addEmpCareer(employee) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Employee>> getAllEmployeeCareer(){
        AppResult<List<Employee>> appResult = new AppResult<>();
        List<Employee> employee = employeeCareerService.getAllEmployeeCareer ();
        appResult = ResultBuilder.successData(ResultCode.OK,employee);
        return appResult;
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/{message}", produces = "application/Json;charset=UTF-8")
    public AppResult<List<Employee>>  viewJob(@PathVariable("message") String message,
                                            @RequestParam(value = "type", required = false) String type ){
        AppResult<List<Employee>> appResult = new AppResult<>();
        if(type.equals("id")){

            List<Employee> employee = employeeCareerService.getEmployeeCareerById (message);
            appResult = ResultBuilder.successData(ResultCode.OK,employee);
        }

        else if(type.equals("name")){
            List<Employee> employee = employeeCareerService.getEmployeeCareerByName (message);
            appResult = ResultBuilder.successData(ResultCode.OK,employee);
        }

        else appResult = ResultBuilder.fail(ResultCode.BadRequest);

        return appResult;
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public RespBean deleteEmpCareerByid(@PathVariable("id") String id) {
        if (employeeCareerService.deleteEmpCareerByid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/")
    public RespBean updateEmpCareer(@RequestBody Employee employee) {

        if (employeeCareerService.updateEmpCareer(employee) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
