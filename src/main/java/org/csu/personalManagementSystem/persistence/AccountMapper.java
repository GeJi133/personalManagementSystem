package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
//    Account getAccountByUsername(String username);
//
//    Account getSignOnByUsername(String username);
//
//    Account getAccountByPhone(Account account);
//
//    Account getSignOnByPhone(Account account);
//
//    Account getSignOnByUsernameAndPassword(Account account);
//
//    void insertAccount(Account account);
//
//    void insertProfile(Account account);
//
//    void insertSignon(Account account);
//
//    void updateAccount(Account account);
//
//    void updateProfile(Account account);
//
//    void updateSignon(Account account);
//
//    Account checkPhone(String phone);
//
    void updatePassword(Account account);
    Account getAccountByUsernameAndPassword(String username,String password);
    Account getAccountByusername(String username);
}


