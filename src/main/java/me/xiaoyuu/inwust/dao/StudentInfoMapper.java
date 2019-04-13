package me.xiaoyuu.inwust.dao;

import me.xiaoyuu.inwust.core.Mapper;
import me.xiaoyuu.inwust.model.StudentInfo;
import org.apache.ibatis.annotations.Param;

public interface StudentInfoMapper extends Mapper<StudentInfo> {


    void insertOneWithIgnore(@Param("studentInfo") StudentInfo studentInfo);

    int  isExistByStudentId(@Param("studentId") String studentId);

    int isExistByStudentName(@Param("studentName") String studentName);
}