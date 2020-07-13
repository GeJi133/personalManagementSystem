package org.csu.personalManagementSystem.domain;

public class Salary {
    private String salaryid;
    private String id;
    private int basicsalary;
    private int insurance;
    private int awardmoney;
    private int finedmoney;
    private int finalsalary;
    private String name;
    private String email;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSalaryid() {
        return salaryid;
    }

    public void setSalaryid(String salaryid) {
        this.salaryid = salaryid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(int basicsalary) {
        this.basicsalary = basicsalary;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public int getAwardmoney() {
        return awardmoney;
    }

    public void setAwardmoney(int awardmoney) {
        this.awardmoney = awardmoney;
    }

    public int getFinedmoney() {
        return finedmoney;
    }

    public void setFinedmoney(int finedmoney) {
        this.finedmoney = finedmoney;
    }

    public int getFinalsalary() {
        return finalsalary;
    }

    public void setFinalsalary(int finalsalary) {
        this.finalsalary = finalsalary;
    }
}
