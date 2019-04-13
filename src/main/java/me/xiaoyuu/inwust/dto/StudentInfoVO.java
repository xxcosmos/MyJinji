package me.xiaoyuu.inwust.dto;

import me.xiaoyuu.inwust.model.CollegeInfo;
import me.xiaoyuu.inwust.model.MajorInfo;
import me.xiaoyuu.inwust.model.StudentInfo;

public class StudentInfoVO {
    private StudentInfo studentInfo;
    private MajorInfo majorInfo;
    private CollegeInfo collegeInfo;

    public StudentInfoVO(StudentInfo studentInfo, MajorInfo majorInfo, CollegeInfo collegeInfo) {
        this.studentInfo = studentInfo;
        this.majorInfo = majorInfo;
        this.collegeInfo = collegeInfo;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public MajorInfo getMajorInfo() {
        return majorInfo;
    }

    public void setMajorInfo(MajorInfo majorInfo) {
        this.majorInfo = majorInfo;
    }

    public CollegeInfo getCollegeInfo() {
        return collegeInfo;
    }

    public void setCollegeInfo(CollegeInfo collegeInfo) {
        this.collegeInfo = collegeInfo;
    }
}
