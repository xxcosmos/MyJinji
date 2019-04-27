package me.xiaoyuu.inwust.service;

import me.xiaoyuu.inwust.model.CourseInfo;
import me.xiaoyuu.inwust.core.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/04/27.
 */
public interface CourseInfoService extends Service<CourseInfo> {
    List<CourseInfo> getByCourseName(String keyword);

    List<CourseInfo> getByCollegeCode(String collegeCode);

    List<CourseInfo> getByTeacherName(String keyword);

    int getNumByTeacherNameAndCourseName(String teacherName, String courseName);

    CourseInfo getByTeacherNameAndCourseName(String teacherName, String courseName);

    void dbProcess(List<CourseInfo> courseInfoList);
}
