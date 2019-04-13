package me.xiaoyuu.inwust.service;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.core.Service;


/**
 * Created by xiaoyuu on 2019/04/12.
 */
public interface StudentInfoService extends Service<StudentInfo> {
    void saveWithIgnore(StudentInfo studentInfo);

    int isExistByStudentId(String studentId);

    int isExistByStudentName(String studentName);
}
