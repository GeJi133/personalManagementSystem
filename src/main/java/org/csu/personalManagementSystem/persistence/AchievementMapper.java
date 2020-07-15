package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Achievement;
import org.csu.personalManagementSystem.domain.Attendance;
import org.csu.personalManagementSystem.domain.DepartmentTransfer;

import java.util.ArrayList;
import java.util.List;

public interface AchievementMapper {

//    ArrayList<Achievement> getAllAchievement();     //查询所有绩效
//
//    ArrayList<Achievement> getAchievementByDate(String startData,String endData);       //查询一段时间内的所有绩效

    ArrayList<Achievement> getAchievementByDateAndId(String startData,String endData,String id);        //查询一段时间内某个员工的绩效
    ArrayList<Attendance> getAttendanceByDateAndId(String startData,String endData,String id);      //查询一段时间内某个员工的出勤记录
    ArrayList<Attendance> getNotAttendanceByDateAndId(String startData,String endData,String id);      //查询一段时间内某个员工的出勤记录
    ArrayList<Attendance> getLateAttendanceByDateAndId(String startData,String endData,String id);      //查询一段时间内某个员工的出勤记录
//    ArrayList<Achievement> getAchievementByYearAndMonth(String year, String month);     //查询某年某月的所有绩效
//
//    ArrayList<Achievement> getAchievementByYearMonthAndId(String year, String month,String id);     //查询某年某月某个员工的绩效


}
