package me.xiaoyuu.inwust.service.impl;

import me.xiaoyuu.inwust.dao.CourseInfoMapper;
import me.xiaoyuu.inwust.model.CourseInfo;
import me.xiaoyuu.inwust.service.CourseInfoService;
import me.xiaoyuu.inwust.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/04/27.
 */
@Service
@Transactional
public class CourseInfoServiceImpl extends AbstractService<CourseInfo> implements CourseInfoService {
    @Resource
    private CourseInfoMapper courseInfoMapper;


    public List<CourseInfo> getByCollegeCode(String collegeCode) {
        return courseInfoMapper.selectByCollegeCode(collegeCode);

    }

    public List<CourseInfo> getByCourseName(String keyword) {
        return courseInfoMapper.selectByCourseName(keyword);
    }

    public List<CourseInfo> getByTeacherName(String keyword) {
        return courseInfoMapper.selectByTeacherName(keyword);
    }

}
