package org.csu.personalManagementSystem.domain;
import java.sql.Time;
import java.sql.Timestamp;

public class Clock {
    private String attendid;
    private String id;
    private Timestamp attendtime;
    private Timestamp leavetime;
    private String name;

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

    private String email;
    private String sex;

    public void setAttendid(String attendid) {
        this.attendid = attendid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAttendtime(Timestamp attendtime) {
        this.attendtime = attendtime;
    }

    public void setLeavetime(Timestamp leavetime) {
        this.leavetime = leavetime;
    }

    public String getAttendid() {
        return attendid;
    }

    public String getId() {
        return id;
    }

    public Timestamp getAttendtime() {
        return attendtime;
    }

    public Timestamp getLeavetime() {
        return leavetime;
    }
}
