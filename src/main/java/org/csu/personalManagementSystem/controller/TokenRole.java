package org.csu.personalManagementSystem.controller;

public class TokenRole {
    String token;
    String role;

    public TokenRole(String role,String token) {
        this.role = role;
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
