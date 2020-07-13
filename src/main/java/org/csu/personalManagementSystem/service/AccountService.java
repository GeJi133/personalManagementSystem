package org.csu.personalManagementSystem.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.csu.personalManagementSystem.domain.Account;
import org.csu.personalManagementSystem.other.AliyunMessageUtil;
import org.csu.personalManagementSystem.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAccountByUsernameAndPassword(String username,String password){
        Account account = accountMapper.getAccountByUsernameAndPassword(username,password);
        return account;
    }

    public Account getAccountByUsername(String username){
        Account account = accountMapper.getAccountByUsername(username);
        return account;
    }

    public void updatePassword(Account account) {
        accountMapper.updatePassword (account);
   }
}
