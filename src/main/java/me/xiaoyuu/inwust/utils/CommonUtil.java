package me.xiaoyuu.inwust.utils;

import me.xiaoyuu.inwust.dto.ImageUploadResponse;
import me.xiaoyuu.inwust.dto.ImageUploadSuccessData;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.model.StudentPic;
import me.xiaoyuu.inwust.service.StudentInfoService;
import me.xiaoyuu.inwust.service.StudentPicService;
import me.xiaoyuu.inwust.utils.RestTemplate.RestTemplateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonUtil {
    private static final String imageURL = "http://jwxt.wust.edu.cn/whkjdx/uploadfile/studentphoto/pic/";
    private static final String uploadURL = "https://sm.ms/api/upload";

    public static byte[] getPicture(String studentId) {
        String url = getStudentPicUrl(studentId);
        RestTemplate restTemplate = RestTemplateUtil.getInstance();
        ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class);
        return responseEntity.getBody();
    }

    public static String getStudentPicUrl(String studentId) {
        return imageURL + studentId + ".JPG";
    }

    /**
     * smms 上传文件
     *
     * @param file
     * @return
     */
    public static ImageUploadResponse uploadImage(File file) {
        RestTemplate restTemplate = RestTemplateUtil.getInstance();
        FileSystemResource resource = new FileSystemResource(file);
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("smfile", resource);
        HttpHeaders headers = getHttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(multiValueMap, headers);
        return restTemplate.postForObject(uploadURL, httpEntity, ImageUploadResponse.class);
    }

    /**
     * get Headers
     *
     * @return
     */
    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return headers;
    }



}
