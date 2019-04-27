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

    public int getNumByTeacherNameAndCourseName(String teacherName, String courseName) {
        return courseInfoMapper.selectNumByTeacherNameAndCourseName(teacherName, courseName);
    }

    public CourseInfo getByTeacherNameAndCourseName(String teacherName, String courseName) {
        return courseInfoMapper.selectByTeacherNameAndCourseName(teacherName, courseName);
    }

    public void dbProcess(List<CourseInfo> courseInfoList) {
        for (CourseInfo courseInfo : courseInfoList) {
            String teacherName = courseInfo.getTeacherName();
            String courseName = courseInfo.getCourseName();
            int num = getNumByTeacherNameAndCourseName(teacherName, courseName);
            if (num == 0) {
                System.out.println("save   " + courseName + " " + teacherName);
                this.save(courseInfo);
            } else if (num == 1) {
                CourseInfo dbInfo = getByTeacherNameAndCourseName(teacherName, courseName);
                dbInfo.setAverageGrade(courseInfo.getAverageGrade());
                dbInfo.setPassPercent(courseInfo.getPassPercent());
                dbInfo.setGradeCount(courseInfo.getGradeCount());
                dbInfo.setUpdateTime(null);
                System.out.println("update    " + courseName + " " + teacherName);
                this.update(dbInfo);
            } else if (num > 1) {
                System.out.println("this course has an error    " + courseName + " " + teacherName);
            }
        }
    }


}
