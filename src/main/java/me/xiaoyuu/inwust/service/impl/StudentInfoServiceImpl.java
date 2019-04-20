package me.xiaoyuu.inwust.service.impl;

import me.xiaoyuu.inwust.dao.StudentInfoMapper;
import me.xiaoyuu.inwust.dto.StudentInfoVO;
import me.xiaoyuu.inwust.model.CollegeInfo;
import me.xiaoyuu.inwust.model.MajorInfo;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.service.CollegeInfoService;
import me.xiaoyuu.inwust.service.MajorInfoService;
import me.xiaoyuu.inwust.service.StudentInfoService;
import me.xiaoyuu.inwust.core.AbstractService;
import me.xiaoyuu.inwust.utils.StudentInfoUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static me.xiaoyuu.inwust.utils.StudentInfoUtil.getWorkBook;
import static me.xiaoyuu.inwust.utils.StudentInfoUtil.isChangeMajor;


/**
 * Created by xiaoyuu on 2019/04/12.
 */
@Service
@Transactional
public class StudentInfoServiceImpl extends AbstractService<StudentInfo> implements StudentInfoService {
    @Resource
    private StudentInfoMapper studentInfoMapper;
    @Resource
    private MajorInfoService majorInfoService;
    @Resource
    private CollegeInfoService collegeInfoService;

    public StudentInfoVO getStudentInfoVo(String studentName) {
        StudentInfo studentInfo = this.findBy("studentName", studentName);
        MajorInfo majorInfo = majorInfoService.findBy("majorCode", studentInfo.getMajorCode());
        CollegeInfo collegeInfo = collegeInfoService.findBy("collegeCode", majorInfo.getCollegeCode());
        return new StudentInfoVO(studentInfo, majorInfo, collegeInfo);
    }

    public void saveWithIgnore(StudentInfo studentInfo) {
        studentInfoMapper.insertOneWithIgnore(studentInfo);
    }

    public int isExistByStudentId(String studentId) {
        return studentInfoMapper.isExistByStudentId(studentId);
    }

    public int isExistByStudentName(String studentName) {
        return studentInfoMapper.isExistByStudentName(studentName);
    }

    public List<StudentInfo> getNameListWithMajor(String fileName) throws IOException {
        majorInfoService.findAll();
        Workbook workbook = getWorkBook(fileName);
        List<StudentInfo> studentInfoList = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        //对每一行进行处理
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            String studentName = row.getCell(0).getStringCellValue().trim();
            String studentId = row.getCell(1).getStringCellValue().trim();
            String major = row.getCell(2).getStringCellValue().trim().split("\\d")[0];
            if (major.contains("机械")) {
                major = "机械类";
            } else if (major.contains("计算机")) {
                major = "计算机科学与技术";
            } else if (major.contains("软件")) {
                major = "软件工程";
            } else if (major.contains("信安")) {
                major = "信息安全";
            } else if (major.contains("网络")) {
                major = "网络工程";
            } else if (major.contains("工商管理")) {
                major = "工商管理";
            } else if (major.contains("临床医学")) {
                major = "临床医学";
            }
            MajorInfo majorInfo = null;
            if (!"".equals(major)) {
                majorInfo = majorInfoService.findBy("majorName", major);
                if (majorInfo == null)
                    System.out.println(major);
            }


            //从数据库中查找学生
            StudentInfo studentInfo = findBy("studentId", studentId);
            if (studentInfo == null) {
                System.out.println(studentId + studentName + major);
            }
            if (studentInfo != null) {
                //已存在
                if (majorInfo != null && !majorInfo.getMajorCode().equals(studentInfo.getMajorCode()) && isChangeMajor(studentId, majorInfo)) {
                    //转专业
                    studentInfo.setMajorCode(majorInfo.getMajorCode());
                    studentInfo.setUpdateTime(null);
                    studentInfoList.add(studentInfo);
                }

            } else {
                //不存在
                if (majorInfo != null) {
                    studentInfo = new StudentInfo(studentId, studentName, majorInfo.getMajorCode());
                } else {
                    studentInfo = new StudentInfo(studentId, studentName);
                }
                studentInfoList.add(studentInfo);
            }
        }
        return studentInfoList;
    }


    /**
     * 从xlsx或者xls文件中读取id-name的记录
     *
     * @param fileName 文件路径
     * @return StudentInfoList
     * @throws IOException
     */
    public List<StudentInfo> getIdNameList(String fileName) throws IOException {
        Workbook workbook = getWorkBook(fileName);
        Sheet sheet = workbook.getSheetAt(0);
        List<StudentInfo> studentInfoList = new ArrayList<>();
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String studentId = row.getCell(0).getStringCellValue().trim();
            String studentName = row.getCell(1).getStringCellValue().trim();
            StudentInfo studentInfo = new StudentInfo(studentId, studentName);
            studentInfoList.add(studentInfo);
        }
        workbook.close();
        return studentInfoList;
    }
}
