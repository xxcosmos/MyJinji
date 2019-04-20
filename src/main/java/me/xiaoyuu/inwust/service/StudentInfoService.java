package me.xiaoyuu.inwust.service;

import me.xiaoyuu.inwust.dto.StudentInfoVO;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.core.Service;

import java.io.IOException;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/04/12.
 */
public interface StudentInfoService extends Service<StudentInfo> {
    public StudentInfoVO getStudentInfoVo(String studentName);

    void saveWithIgnore(StudentInfo studentInfo);

    int isExistByStudentId(String studentId);

    int isExistByStudentName(String studentName);

    List<StudentInfo> getNameListWithMajor(String fileName) throws IOException;

    List<StudentInfo> getIdNameList(String fileName) throws IOException;
}
