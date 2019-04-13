package me.xiaoyuu.inwust.dao;

import me.xiaoyuu.inwust.core.Mapper;
import me.xiaoyuu.inwust.model.CourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CourseInfoMapper extends Mapper<CourseInfo> {

     void insertOneWithIgnore(@Param("courseInfo") CourseInfo courseInfo);

     void insertAlltWithIgnore(@Param("courseInfoList")List<CourseInfo> courseInfoList);

     List<CourseInfo> selectByCollegeCode(@Param("collegeCode") String collegeCode);

     List<CourseInfo> selectByCourseName(@Param("keyword") String keyword);
     List<CourseInfo> selectByTeacherName(@Param("keyword") String keyword);

}