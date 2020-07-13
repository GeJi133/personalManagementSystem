package org.csu.personalManagementSystem.controller;

import org.csu.personalManagementSystem.domain.AppResult;
import org.csu.personalManagementSystem.other.*;
import org.springframework.util.DigestUtils;
import com.aliyuncs.exceptions.ClientException;
import org.csu.personalManagementSystem.domain.Account;
import org.csu.personalManagementSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {

    @Autowired
    AccountService accountService;
    
    @PostMapping(value = "/login",produces="application/Json;charset=UTF-8" )
    @ResponseBody
    public AppResult<String> Login(@RequestParam("username") String username, @RequestParam("password") String  password) {
        AppResult<String> appResult = new AppResult<>();
        Account account = accountService.getAccountByUsernameAndPassword (username,password);
        System.out.println ("接受到请求");
        System.out.println (account);
        if(account == null)
        {
            appResult = ResultBuilder.fail(ResultCode.UsernameOrPasswordEror);
        }
        else
        {
            String token = JwtUtil.createJWT(username);
            appResult = ResultBuilder.successData(ResultCode.OK,token);
        }
        return appResult;
    }


    @PatchMapping(value = "/",produces="application/Json;charset=UTF-8")
    public AppResult<String> updatePassword(@RequestBody Account account){
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






}
