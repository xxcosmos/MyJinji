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

    public List<CourseInfo> getByTeacherNameAndCourseName(String teacherName, String courseName) {
        return courseInfoMapper.selectByTeacherNameAndCourseName(teacherName, courseName);
    }

    public int updateCourseCredit(CourseInfo courseInfo) {
        return courseInfoMapper.updateCourseCredit(courseInfo);
    }

    public void dbProcess(List<CourseInfo> courseInfoList) {
        for (CourseInfo courseInfo : courseInfoList) {
            courseInfo.setId(null);
            String teacherName = courseInfo.getTeacherName();
            String courseName = courseInfo.getCourseName();
            List<CourseInfo> courseInfoList1 = getByTeacherNameAndCourseName(teacherName, courseName);
            if (courseInfoList1 == null || courseInfoList1.size() == 0) {
                System.out.println("save   " + courseName + " " + teacherName);
                this.save(courseInfo);


            } else {
                for (CourseInfo dbInfo : courseInfoList1) {
                    dbInfo.setUpdateTime(null);
                    dbInfo.setAverageGrade(courseInfo.getAverageGrade());
                    dbInfo.setPassPercent(courseInfo.getPassPercent());
                    dbInfo.setGradeCount(courseInfo.getGradeCount());
                    System.out.println("update    " + courseName + " " + teacherName);
                    this.update(dbInfo);
                }
            }
        }
    }


}
