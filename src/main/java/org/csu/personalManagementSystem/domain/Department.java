package org.csu.personalManagementSystem.domain;

public class Department {
    private String dno;
    private String department;
    private String business;
    private String manager; //部门经理，只能get到，要修改到员工信息修改模块去修改
    private String performance;


    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getManager() {
        return manager;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public Department(){

    }

    public Department(String dno, String department, String business) {
        this.dno = dno;
        this.department = department;
        this.business = business;
    }
}
