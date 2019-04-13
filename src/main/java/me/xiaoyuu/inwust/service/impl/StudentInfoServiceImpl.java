package me.xiaoyuu.inwust.service.impl;

import me.xiaoyuu.inwust.dao.StudentInfoMapper;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.service.StudentInfoService;
import me.xiaoyuu.inwust.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/04/12.
 */
@Service
@Transactional
public class StudentInfoServiceImpl extends AbstractService<StudentInfo> implements StudentInfoService {
    @Resource
    private StudentInfoMapper studentInfoMapper;

    public void saveWithIgnore(StudentInfo studentInfo){
        studentInfoMapper.insertOneWithIgnore(studentInfo);
    }

    public int isExistByStudentId(String studentId){
        return studentInfoMapper.isExistByStudentId(studentId);
    }

    public int isExistByStudentName(String studentName){
        return studentInfoMapper.isExistByStudentName(studentName);
    }
}
