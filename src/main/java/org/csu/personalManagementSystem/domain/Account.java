package org.csu.personalManagementSystem.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class Account {
    @NotNull(message = "用户名不能为空")
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
