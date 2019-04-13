package me.xiaoyuu.inwust;

import me.xiaoyuu.inwust.model.CollegeInfo;
import me.xiaoyuu.inwust.model.MajorInfo;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.service.CollegeInfoService;
import me.xiaoyuu.inwust.service.CourseInfoService;
import me.xiaoyuu.inwust.service.MajorInfoService;
import me.xiaoyuu.inwust.service.StudentInfoService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Parse extends Tester {

    @Resource
    StudentInfoService studentInfoService;
    @Resource
    CourseInfoService courseInfoService;
    @Resource
    CollegeInfoService collegeInfoService;
    @Resource
    MajorInfoService majorInfoService;

    @Test
    public void test2() {
        String path = "/Users/xiaoyuu/IdeaProjects/my-springboot-seed-project/src/main/resources/static/xlsx";
        File file = new File(path);
        File[] files = file.listFiles();
        assert files != null;
        int allCnt = 0;
        int cnt;
        for (File f : files) {
            cnt = 0;
            try {
                FileInputStream fileInputStream = new FileInputStream(f);
                Workbook workbook = new HSSFWorkbook(fileInputStream);
                Sheet sheet = workbook.getSheetAt(0);

                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    String studentId = row.getCell(0).getStringCellValue().trim();
                    String studentName = row.getCell(1).getStringCellValue().trim();
                    StudentInfo studentInfo = new StudentInfo(studentId, studentName);
                    if (studentInfoService.findBy("studentId", studentId) == null) {
                        studentInfoService.save(studentInfo);
                        System.out.println(studentInfo);
                        cnt++;
                    }
                }
                System.out.println(f.getName() + "   cnt=" + cnt);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            allCnt += cnt;

        }
        System.out.println("allCnt" + allCnt);

//        StudentInfo studentInfo =studentInfoService.findBy("studentName","张少哲");
//        System.out.println(studentInfo);

//        List<CollegeInfo> collegeInfoList = collegeInfoService.findAll();
//        Map<String, CollegeInfo> collegeInfoMap = new HashMap<>();
//        for (CollegeInfo collegeInfo : collegeInfoList) {
//            collegeInfoMap.put(collegeInfo.getCollegeName().trim(), collegeInfo);
//        }

//        List<MajorInfo> majorInfoList = majorInfoService.findAll();
//        Map<String, MajorInfo> majorMapByName = new HashMap<>();
//        Map<Integer, MajorInfo> majorMapById = new HashMap<>();
//        for (MajorInfo majorInfo : majorInfoList) {
//            majorMapByName.put(majorInfo.getMajorName(), majorInfo);
//            majorMapById.put(majorInfo.getId(), majorInfo);
//        }
//
//        try {
//            String path = "/Users/xiaoyuu/IdeaProjects/my-springboot-seed-project/src/main/resources/static/de03787c-78fa-468e-99ba-37ffbb7d8b94.xlsx";
//            Workbook workbook = new XSSFWorkbook(path);
//            Sheet sheet = workbook.getSheetAt(0);
//            //对每一行进行处理
//            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//                Row row = sheet.getRow(i);
//                String studentId = row.getCell(0).getStringCellValue().trim();
//                String studentName = row.getCell(1).getStringCellValue().trim();
//               // String college = row.getCell(2).getStringCellValue().trim();
//                String major = row.getCell(2).getStringCellValue().trim().split("2")[0];
//
////                if (major.contains("机械")) {
////                    major = "机械类";
////                } else
//                if (major.contains("工商管理")) {
//                    major = "工商管理";
//                } else if (major.contains("临床医学")) {
//                    major = "临床医学";
//                } else if (major.contains("电气工程及其自动化")) {
//                    major = "电气工程及自动化";
//                }
//
//                MajorInfo majorInfo = majorMapByName.get(major);
//                if (majorInfo==null){
//                    System.out.println("major" + major + "，  studentId" + studentId.substring(6, 9));
//                    System.out.println(studentId+studentName);
//                }
//
//                StudentInfo query = studentInfoService.findBy("studentId", studentId);
//                if (query != null) {
//                    //已存在
//                    if (majorInfo != null) {
//                        Integer queryMajorId = query.getMajorId();
//
//                        if (queryMajorId != null && !queryMajorId.equals(majorInfo.getId()) && studentId.substring(6, 9).equals(majorMapById.get(query.getMajorId()).getMajorCode())) {
//                            //转专业
//                            query.setCollegeId(majorInfo.getCollegeId());
//                            query.setMajorId(majorInfo.getId());
//                            query.setUpdateTime(null);
//                            studentInfoService.update(query);
//                            System.out.println(query);
//                        }
//
//                        if (query.getMajorId() == null) {
//                            query.setCollegeId(majorMapByName.get(major).getCollegeId());
//                            query.setMajorId(majorMapByName.get(major).getId());
//                            query.setUpdateTime(null);
//                            studentInfoService.update(query);
//                            System.out.println(query);
//                        }
//
//                    }
//
//                } else {
//                    //不存在
//                    if (majorInfo != null) {
//                        query = new StudentInfo(studentId, studentName, majorMapByName.get(major).getCollegeId(), majorMapByName.get(major).getId());
//
//                    } else {
//                        query = new StudentInfo(studentId, studentName);
//
//                    }
//                    studentInfoService.save(query);
//                    System.out.println(query);
//                }
//            }
//            System.out.println("odek");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void test() {
        // studentInfoService.save(new StudentInfo("xxx","xxx"));
        // StudentInfo studentInfo = new StudentInfo("xxx", "xxx", 1, 2);
//        StudentInfo studentInfo1 = studentInfoService.findBy("studentId","xxx");
//        studentInfo1.setMajorId(2);
//        studentInfo1.setCollegeId(2);
//        studentInfo1.setUpdateTime(null);
//        studentInfoService.update(studentInfo1);
//        System.out.println(studentInfoService.findBy("studentId","xxx"));
//        try {
//            String path = "ç/Users/xiaoyuu/IdeaProjects/my-springboot-seed-project/src/main/resources/static/323893bcbd45.xlsx";
//            Workbook workbook = new XSSFWorkbook(path);
//            Sheet sheet = workbook.getSheetAt(0);
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//                Row row = sheet.getRow(i);
//                String studentId = row.getCell(0).getStringCellValue().trim();
//                String studentName = row.getCell(1).getStringCellValue().trim();
//                String college = row.getCell(2).getStringCellValue().trim();
//                String major = row.getCell(3).getStringCellValue().trim().split("（")[0];
//                // StudentInfo studentInfo =new StudentInfo(studentId,studentName,collegeMap.get(college),majorMap.get(major));
//                //System.out.println(studentInfo);
//                System.out.println(studentId + studentName + college + major);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
////       }
        try {
            Workbook workbook = new XSSFWorkbook("/Users/xiaoyuu/IdeaProjects/my-springboot-seed-project/src/main/resources/static/4874d736-47c4-4334-9cbc-c348eda35cba.xlsx");
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String studentId = row.getCell(0).getStringCellValue().trim();
                String studentName = row.getCell(1).getStringCellValue().trim();
                StudentInfo studentInfo = new StudentInfo(studentId, studentName);
                // studentInfoService.saveWithIgnore(studentInfo);
                StudentInfo query = studentInfoService.findBy("studentId", studentId);
                if (query == null) {
                    // studentInfoService.deleteById(query.getId());
                    studentInfoService.save(studentInfo);
                    System.out.println(studentId + studentName);
                }
            }
            System.out.println("ok");
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testxxxx() {
        List<StudentInfo> studentInfoList = studentInfoService.findAll();
        for (StudentInfo s :
                studentInfoList) {
            studentInfoService.deleteById(s.getId());
            s.setStudentName(s.getStudentName().trim());
            s.setStudentId(s.getStudentId().trim());
            studentInfoService.saveWithIgnore(s);

        }
    }
}
