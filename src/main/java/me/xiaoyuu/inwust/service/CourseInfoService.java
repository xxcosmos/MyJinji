package me.xiaoyuu.inwust.service;
import me.xiaoyuu.inwust.model.CourseInfo;
import me.xiaoyuu.inwust.core.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/04/10.
 */
public interface CourseInfoService extends Service<CourseInfo> {
    void saveWithIgnore(CourseInfo courseInfo);
    void saveWithIgnore(List<CourseInfo> courseInfoList);
    List<CourseInfo> getByCourseName(String keyword);
    List<CourseInfo> getByCollegeCode(String collegeCode);
    List<CourseInfo> getByTeacherName(String keyword);
}
