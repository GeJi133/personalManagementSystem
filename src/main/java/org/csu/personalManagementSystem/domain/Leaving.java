package org.csu.personalManagementSystem.domain;

import java.util.Date;

public class Leaving {
    private String leavingId;
    private String id;
    private String department;
    private Date leavingTime;
    private String leavingReason;
    private String status;
    public String getLeavingId() {
        return leavingId;
    }

    public void setLeavingId(String leavingId) {
        this.leavingId = leavingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getLeavingTime() {
        return leavingTime;
    }

    public void setLeavingTime(Date leavingTime) {
        this.leavingTime = leavingTime;
    }

    public String getLeavingReason() {
        return leavingReason;
    }

    public void setLeavingReason(String leavingReason) {
        this.leavingReason = leavingReason;
    }
}
