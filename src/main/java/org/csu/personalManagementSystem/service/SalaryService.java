package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Achievement;
import org.csu.personalManagementSystem.domain.Attendance;
import org.csu.personalManagementSystem.domain.Employee;
import org.csu.personalManagementSystem.domain.Salary;
import org.csu.personalManagementSystem.persistence.AchievementMapper;
import org.csu.personalManagementSystem.persistence.EmployeeLanguageMapper;
import org.csu.personalManagementSystem.persistence.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {

    @Autowired

    SalaryMapper salaryMapper;

    @Autowired
    AchievementMapper achievementMapper;

    /*public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee);
        //Long total = employeeMapper.getTotal(employee);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        //bean.setTotal(total);
        return bean;
    }*/


    public List<Salary> getAllSalary(){
        return salaryMapper.getAllSalary();
    }

    public  List<Salary>  getSalaryById(String id){

        return salaryMapper.getSalaryById(id);
    }

    public List<Salary> getSalaryByName(String name){
        return salaryMapper.getSalaryByName(name);
    }

    public List<Salary> getSalaryByPage(){
        return salaryMapper.getSalaryByPage();
    }

    public Integer updateSalary(Salary salary) {
        return salaryMapper.updateSalaryByPrimaryKeySelective(salary);
    }

    public int getAchievementByDateAndId(String startData,String endData,String id){
        ArrayList<Achievement> achievementArrayList=new ArrayList<>();
        achievementArrayList=achievementMapper.getAchievementByDateAndId(startData,endData,id);
        int result=0;
        for(int i=0;i<achievementArrayList.size();i++){
            result+=achievementArrayList.get(i).getPerformance();
        }
        return result;
    }

    public float[] getAttendanceRateByDateAndId(String startData,String endData,String id){
        ArrayList<Attendance> attendanceArrayList1=new ArrayList<>();
        ArrayList<Attendance> attendanceArrayList2=new ArrayList<>();
        ArrayList<Attendance> attendanceArrayList3=new ArrayList<>();
        attendanceArrayList1=achievementMapper.getAttendanceByDateAndId(startData,endData,id);
        attendanceArrayList2=achievementMapper.getLateAttendanceByDateAndId(startData,endData,id);
        attendanceArrayList3=achievementMapper.getNotAttendanceByDateAndId(startData,endData,id);
        float[] result=new float[3];
        result[0]=attendanceArrayList1.size()/(float)(attendanceArrayList1.size()+attendanceArrayList2.size()+attendanceArrayList3.size());
        result[1]=attendanceArrayList2.size()/(float)(attendanceArrayList1.size()+attendanceArrayList2.size()+attendanceArrayList3.size());
        result[2]=attendanceArrayList3.size()/(float)(attendanceArrayList1.size()+attendanceArrayList2.size()+attendanceArrayList3.size());
        return result;
    }
}

