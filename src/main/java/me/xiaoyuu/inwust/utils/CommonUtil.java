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
    @Resource
    private static StudentPicService studentPicService;
    @Resource
    private static StudentInfoService studentInfoService;
    private static RestTemplate restTemplate = RestTemplateUtil.getInstance();

    private static File getPicture(String studentId) {
        String url = imageURL + studentId + ".JPG";
        //新建RestTemplate,将图片读入bytes中
        ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class);
        File file = new File("/Users/xiaoyuu/IdeaProjects/my-springboot-seed-project/src/main/resources/temp-image.JPG");
        byte[] bytes = responseEntity.getBody();
        if (bytes == null) {
            System.out.println("bytes is null");
            return null;
        }

        try {
            OutputStream outputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(responseEntity.getBody());
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ImageUploadResponse uploadImage(File file) {
        FileSystemResource resource = new FileSystemResource(file);
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("smfile", resource);
        HttpHeaders headers = getHttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(multiValueMap, headers);
        return restTemplate.postForObject(uploadURL, httpEntity, ImageUploadResponse.class);
    }

    public static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return headers;
    }

    public static void main(String[] args) {
        // List<StudentInfo> studentInfoList = studentInfoService.findAll();
        List<StudentInfo> studentInfoList = new ArrayList<>();
        StudentInfo studentInfo1 = new StudentInfo();
        studentInfo1.setStudentId("201713137040");
        studentInfoList.add(studentInfo1);

        for (StudentInfo studentInfo : studentInfoList) {
            String studentId = studentInfo.getStudentId();
            File pic = getPicture(studentId);
            if (pic == null) {
                System.out.println("getFile Failed");
                continue;
            }

            ImageUploadResponse response = uploadImage(pic);
            System.out.println(response);
            if ("success".equals(response.getCode())) {
                //存数据到数据库中
                ImageUploadSuccessData data = response.getData();
                StudentPic studentPic = new StudentPic();
                studentPic.setUrl(data.getUrl());
                studentPic.setStudentId(studentId);
                studentPic.setDeleteUrl(data.getDelete());
                studentPic.setHash(data.getHash());
                studentPicService.save(studentPic);
            }


        }
    }


}
