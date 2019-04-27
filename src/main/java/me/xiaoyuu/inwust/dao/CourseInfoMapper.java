package me.xiaoyuu.inwust.dao;

import me.xiaoyuu.inwust.core.Mapper;
import me.xiaoyuu.inwust.model.CourseInfo;
import me.xiaoyuu.inwust.model.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseInfoMapper extends Mapper<CourseInfo> {
    List<CourseInfo> selectByCollegeCode(@Param("collegeCode") String collegeCode);

    List<CourseInfo> selectByCourseName(@Param("keyword") String keyword);

    List<CourseInfo> selectByTeacherName(@Param("keyword") String keyword);

    List<CourseInfo> selectByTeacherNameAndCourseName(@Param("teacherName") String teacherName, @Param("courseName") String courseName);

    int selectNumByTeacherNameAndCourseName(@Param("teacherName") String teacherName, @Param("courseName") String courseName);

    int updateCourseCredit(@Param("courseInfo") CourseInfo courseInfo);
}