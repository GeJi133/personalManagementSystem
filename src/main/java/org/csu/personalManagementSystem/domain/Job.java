package org.csu.personalManagementSystem.domain;

public class Job {
    private String jno;
    private String dno;
    private String description;
    private String job;

    public String getJno() {
        return jno;
    }

    public void setJno(String jno) {
        this.jno = jno;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Job() {
    }

    public Job(String jno, String dno, String description, String job) {
        this.jno = jno;
        this.dno = dno;
        this.description = description;
        this.job = job;
    }
}
