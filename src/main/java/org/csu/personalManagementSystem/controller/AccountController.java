package org.csu.personalManagementSystem.controller;

import org.csu.personalManagementSystem.domain.*;
import org.csu.personalManagementSystem.other.*;
import org.csu.personalManagementSystem.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.DigestUtils;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController

@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    AccountService accountService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RoleService roleService;

    @Autowired
    MailService mailService;

    @PostMapping("/login")
    @ResponseBody
    public AppResult<TokenRole> login(@RequestParam("username") String username, @RequestParam("password") String  password) throws JSONException {

        AppResult<TokenRole> appResult = new AppResult<>();
        Account account = accountService.getAccountByUsernameAndPassword (username,password);
        System.out.println ("接受到请求");
        System.out.println (account);

//        Employee employee=employeeService.getEmployeeByPage ()

        if(account == null)
        {
            appResult = ResultBuilder.fail(ResultCode.UsernameOrPasswordEror);
        }
        else
        {
            final UserDetail userDetail = userDetailsService.loadUserByUsername(username);

            Role role= roleService.getRoleByUserId (username);
            final String token = jwtTokenUtil.generateToken(userDetail);

            TokenRole tokenRole = new TokenRole (role.getName (),token);

            appResult = ResultBuilder.successData(ResultCode.OK,tokenRole);
        }


        return appResult;

    }

//    @PostMapping("/login")
//    @ResponseBody
//    public AppResult<String> login(@RequestBody Employee employee){
//
//
//
//    }
//    @PostMapping(value = "/login",produces="application/Json;charset=UTF-8" )
//    @ResponseBody
//    public AppResult<String> Login(@RequestParam("username") String username, @RequestParam("password") String  password) {
//        AppResult<String> appResult = new AppResult<>();
//        Account account = accountService.getAccountByUsernameAndPassword (username,password);
//        System.out.println ("接受到请求");
//        System.out.println (account);
//        if(account == null)
//        {
//            appResult = ResultBuilder.fail(ResultCode.UsernameOrPasswordEror);
//        }
//        else
//        {
//            String token = JwtUtil.createJWT(username);
//            appResult = ResultBuilder.successData(ResultCode.OK,token);
//        }
//        return appResult;
//    }

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
