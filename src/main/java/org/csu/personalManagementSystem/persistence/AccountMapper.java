package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    void updatePassword(Account account);
    Account getAccountByUsernameAndPassword(String username,String password);
    Account getAccountByUsername(String username);
}


