package me.xiaoyuu.inwust.utils;

import me.xiaoyuu.inwust.model.MajorInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class StudentInfoUtil {
    /**
     * 是否转专业
     *
     * @param studentId 学号信息
     * @param majorInfo 专业信息
     * @return
     */
    public static boolean isChangeMajor(String studentId, MajorInfo majorInfo) {
        return !studentId.substring(6, 9).equals(majorInfo.getMajorCode());
    }


    /**
     * 拿到WorkBook
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Workbook getWorkBook(String fileName) throws IOException {
        Workbook workbook;
        if (fileName.split("\\.")[1].equals("xls")) {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            workbook = new HSSFWorkbook(fileInputStream);
            fileInputStream.close();
        } else {
            workbook = new XSSFWorkbook(fileName);
        }
        return workbook;
    }
}
