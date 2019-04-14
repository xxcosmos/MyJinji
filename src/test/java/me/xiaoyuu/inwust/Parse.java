package me.xiaoyuu.inwust;

import me.xiaoyuu.inwust.model.MajorInfo;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.service.CollegeInfoService;
import me.xiaoyuu.inwust.service.MajorInfoService;
import me.xiaoyuu.inwust.service.StudentInfoService;
import me.xiaoyuu.inwust.utils.StudentInfoUtil;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parse extends Tester {

    @Resource
    StudentInfoService studentInfoService;
    @Resource
    MajorInfoService majorInfoService;
    @Resource
    CollegeInfoService collegeInfoService;

    @Test
    public void test() {
        StudentInfoUtil studentInfoUtil = new StudentInfoUtil();
        List<StudentInfo> studentInfoList = new ArrayList<>();
        try {
            studentInfoList = studentInfoService.getNameListWithMajor("/Users/xiaoyuu/IdeaProjects/my-springboot-seed-project/src/main/resources/static/Name-No-class.xlsx");
            for (StudentInfo s : studentInfoList
            ) {
                if (studentInfoService.findBy("studentId", s.getStudentId()) != null) {
                    studentInfoService.update(s);
                } else {
                    studentInfoService.save(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {
        List<StudentInfo> studentInfoList = studentInfoService.findAll();
        for (StudentInfo studentInfo : studentInfoList) {
            String majorCode = studentInfo.getMajorCode();
            if ("".equals(majorCode) || majorCode == null) {
            } else {
                studentInfo.setUpdateTime(null);
                MajorInfo majorInfo = majorInfoService.findBy("id", Integer.valueOf(majorCode));
                studentInfo.setMajorCode(majorInfo.getMajorCode());
                studentInfoService.update(studentInfo);
            }


        }
    }

}
