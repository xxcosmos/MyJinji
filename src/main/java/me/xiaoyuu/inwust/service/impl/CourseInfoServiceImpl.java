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
 * Created by xiaoyuu on 2019/04/10.
 */
@Service
@Transactional
public class CourseInfoServiceImpl extends AbstractService<CourseInfo> implements CourseInfoService {
    @Resource
    private CourseInfoMapper courseInfoMapper;

    public void saveWithIgnore(CourseInfo courseInfo){
        courseInfoMapper.insertOneWithIgnore(courseInfo);
    }

    public void saveWithIgnore(List<CourseInfo> courseInfoList){
        courseInfoMapper.insertAlltWithIgnore(courseInfoList);
    }

    public List<CourseInfo> getByCollegeCode(String collegeCode){
       return courseInfoMapper.selectByCollegeCode(collegeCode);

    }

    public List<CourseInfo> getByCourseName(String keyword){
        return courseInfoMapper.selectByCourseName(keyword);
    }

    public List<CourseInfo> getByTeacherName(String keyword){
        return courseInfoMapper.selectByTeacherName(keyword);
    }


}
