package me.xiaoyuu.inwust;

import me.xiaoyuu.inwust.dto.ImageUploadResponse;
import me.xiaoyuu.inwust.dto.ImageUploadSuccessData;
import me.xiaoyuu.inwust.model.MajorInfo;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.model.StudentPic;
import me.xiaoyuu.inwust.service.CollegeInfoService;
import me.xiaoyuu.inwust.service.MajorInfoService;
import me.xiaoyuu.inwust.service.StudentInfoService;
import me.xiaoyuu.inwust.service.StudentPicService;
import me.xiaoyuu.inwust.utils.StudentInfoUtil;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static me.xiaoyuu.inwust.utils.CommonUtil.getPicture;
import static me.xiaoyuu.inwust.utils.CommonUtil.uploadImage;

public class Parse extends Tester {

    @Resource
    StudentInfoService studentInfoService;
    @Resource
    MajorInfoService majorInfoService;
    @Resource
    CollegeInfoService collegeInfoService;
    @Resource
    StudentPicService studentPicService;

    @Test
    public void testt() {
//        List<StudentInfo> studentInfoList = studentInfoService.findAll();
//
//        for (StudentInfo studentInfo : studentInfoList) {
//            String studentId = studentInfo.getStudentId();
//            if (studentPicService.findBy("studentId",studentId)!=null){
//                continue;
//            }
//            File pic = getPicture(studentId);
//            if (pic == null) {
//                System.out.println("getFile Failed");
//                continue;
//            }
//
//            ImageUploadResponse response = uploadImage(pic);
//            System.out.println(response);
//            if ("success".equals(response.getCode())) {
//                //存数据到数据库中
//                ImageUploadSuccessData data = response.getData();
//                StudentPic studentPic = new StudentPic();
//                studentPic.setUrl(data.getUrl());
//                studentPic.setStudentId(studentId);
//                studentPic.setDeleteUrl(data.getDelete());
//                studentPic.setHash(data.getHash());
//                studentPicService.save(studentPic);
//            }
//
//
//        }
    }
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
