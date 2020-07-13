package org.csu.personalManagementSystem.domain;

public class DepartmentTransfer {
    private String transferId;
    private String id;
    private String transferReason;
    private String transferTime;
    private String departmentBefore;
    private String departmentAfter;
    private String position;

    public String getTransferId() {
        return transferId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransferReason() {
        return transferReason;
    }

    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
    }

    public String getDepartmentBefore() {
        return departmentBefore;
    }

    public void setDepartmentBefore(String departmentBefore) {
        this.departmentBefore = departmentBefore;
    }

    public String getDepartmentAfter() {
        return departmentAfter;
    }

    public void setDepartmentAfter(String departmentAfter) {
        this.departmentAfter = departmentAfter;
    }
}
