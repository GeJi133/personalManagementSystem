package org.csu.personalManagementSystem.controller;

import org.csu.personalManagementSystem.domain.Account;
import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.other.ResultBuilder;
import org.csu.personalManagementSystem.other.ResultCode;
import org.csu.personalManagementSystem.service.AccountService;
import org.csu.personalManagementSystem.service.EmployeeService;
import org.csu.personalManagementSystem.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/email")
@CrossOrigin
public class EmailController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private MailService mailService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public AppResult<String> getEmail(@PathVariable("id") String id) {
        AppResult<String> appResult = new AppResult<>();
        String email=employeeService.getEmployeeById (id).getEmail ();
        int num=email.length();
        String sendEmail=email.substring (0,3)+"***"+email.substring(6,num);
        appResult = ResultBuilder.successData(ResultCode.OK,sendEmail);
        return appResult;
    }

    @PutMapping("/updatePassword")
    @ResponseBody
    public AppResult<String> resetPassword(@RequestBody Account account) {

        AppResult<String> appResult = new AppResult<>();
        if(accountService.getAccountByUsername(account.getUsername())!=null){
            accountService.updatePassword (account);
            appResult = ResultBuilder.successNoData(ResultCode.Handled);
        }
        else {
            appResult = ResultBuilder.fail(ResultCode.BadRequest);
        }
        return appResult;

    }


    @GetMapping("/sendEmail/{id}")
    public AppResult<String> sendEmail(@PathVariable("id") String id) {
        AppResult<String> appResult = new AppResult<>();
        String email=employeeService.getEmployeeById (id).getEmail ();

        String checkCode=String.valueOf (new Random ().nextInt (899999)+100000);
        String message="正在使用邮箱验证；验证码为："+checkCode;
        try{
            mailService.sendSimpleMail (email,"修改密码验证",message);
        }catch (Exception e){
            System.out.println (e);
        }
        appResult = ResultBuilder.successData(ResultCode.OK,checkCode);
        return appResult;
    }



}
