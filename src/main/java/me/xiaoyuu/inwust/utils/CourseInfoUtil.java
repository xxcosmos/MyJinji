package me.xiaoyuu.inwust.utils;

import com.alibaba.fastjson.JSONArray;
import me.xiaoyuu.inwust.dto.RawCourseInfo;
import me.xiaoyuu.inwust.model.CourseInfo;
import me.xiaoyuu.inwust.service.CourseInfoService;
import org.apache.commons.io.IOUtils;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CourseInfoUtil {
    @Resource
    private static CourseInfoService  courseInfoService;

    /**
     * 从课程信息的json中读取课程到course_info表
     * @param file 文件地址
     */
    public static void courseInfoJson2DB(String file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            String text = IOUtils.toString(inputStream, "utf8");
            //得到原始课程信息列表
            List<RawCourseInfo> rawCourseInfoList = JSONArray.parseArray(text, RawCourseInfo.class);

            List<CourseInfo> courseInfoList = new ArrayList<>();
            for (RawCourseInfo rawCourseInfo : rawCourseInfoList) {
                courseInfoList.add(new CourseInfo(rawCourseInfo));
            }
            //保存到数据库
            courseInfoService.saveWithIgnore(courseInfoList);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


}
