package org.csu.personalManagementSystem.domain;

public class JobTransfer {
    private String transferId;
    private String id;
    private String transferReason;
    private String transferTime;
    private String jobBefore;
    private String jobAfter;
    private String status;

    public String getTransferId() {
        return transferId;
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

    public String getJobBefore() {
        return jobBefore;
    }

    public void setJobBefore(String jobBefore) {
        this.jobBefore = jobBefore;
    }

    public String getJobAfter() {
        return jobAfter;
    }

    public void setJobAfter(String jobAfter) {
        this.jobAfter = jobAfter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
