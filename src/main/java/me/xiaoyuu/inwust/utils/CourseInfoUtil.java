package me.xiaoyuu.inwust.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import me.xiaoyuu.inwust.core.Result;
import me.xiaoyuu.inwust.dto.JacseerCourseInfo;
import me.xiaoyuu.inwust.dto.RawCourseInfo;
import me.xiaoyuu.inwust.model.CourseInfo;
import me.xiaoyuu.inwust.utils.RestTemplate.RestTemplateUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourseInfoUtil {

    public static final String gradeURL = "https://https.jakseer.cn/wx_app/Home/Analysis/getCourseAnalysis.html?name=";


    /**
     * 从课程信息的json中读取课程,返回课程list
     *
     * @param json json格式的字符串
     */
    public static List<CourseInfo> getCourseInfoListFromJson(String json) {
        //得到原始课程信息列表
        List<RawCourseInfo> rawCourseInfoList = JSONArray.parseArray(json, RawCourseInfo.class);

        List<CourseInfo> courseInfoList = new ArrayList<>();
        for (RawCourseInfo rawCourseInfo : rawCourseInfoList) {
            courseInfoList.add(new CourseInfo(rawCourseInfo));
        }
        return courseInfoList;
    }

    public static List<CourseInfo> getCourseInfoListFromJson2(String json) {
        List<JacseerCourseInfo> jacseerCourseInfoList = JSONArray.parseArray(json, JacseerCourseInfo.class);
        List<CourseInfo> courseInfoList = new ArrayList<>();
        for (JacseerCourseInfo jacseerCourseInfo : jacseerCourseInfoList) {
            courseInfoList.add(new CourseInfo(jacseerCourseInfo));
        }
        return courseInfoList;
    }

    public static List<CourseInfo> getCourseInfoList(String url) throws NoSuchAlgorithmException, KeyManagementException {
        RestTemplate restTemplate = RestTemplateUtil.getInstance();
        String response = restTemplate.getForObject(url, String.class);
        Result result = JSON.parseObject(response, Result.class);
        assert result != null;
        return getCourseInfoListFromJson2(String.valueOf(result.getData()));

    }


}
