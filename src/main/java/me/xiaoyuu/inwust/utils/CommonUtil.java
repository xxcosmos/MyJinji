package me.xiaoyuu.inwust.utils;

import me.xiaoyuu.inwust.core.Result;
import me.xiaoyuu.inwust.utils.RestTemplate.RestTemplateUtil;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Collections;

public class CommonUtil {
    public static final String IMAGE_URL = "http://jwxt.wust.edu.cn/whkjdx/uploadfile/studentphoto/pic/";
    public static final String UPLOAD_URL = "https://sm.ms/api/upload";
    public static final String PATH_NAME = "/Users/xiaoyuu/StudentPic";

    public static byte[] getPicture(String studentId) {
        String url = getStudentPicUrl(studentId);
        System.out.println(url);
        RestTemplate restTemplate = RestTemplateUtil.getInstance();
        ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class);
        return responseEntity.getBody();
    }

    public static File getPicFile(String studentId) throws IOException {
        String pathName = PATH_NAME + "/" + studentId.substring(4, 6) + "/" + studentId.substring(0, 4);
        File pathFile = new File(pathName);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        String fileName = pathName + "/" + studentId + ".jpg";
        File pic = new File(fileName);
        if (pic.exists()) {
            return null;
        }
        pic.createNewFile();
        return pic;
    }

    public static void savePicToLocal(String studentId) throws IOException {

        File file = getPicFile(studentId);
        if (file == null)
            return;
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] pictureByte = getPicture(studentId);
        outputStream.write(pictureByte);
        outputStream.close();
    }

    public static String getStudentPicUrl(String studentId) {
        return IMAGE_URL + studentId + ".JPG";
    }

    /**
     * smms 上传文件
     *
     * @param file 文件
     * @return response
     */
    public static Result uploadImage(File file) {
        RestTemplate restTemplate = RestTemplateUtil.getInstance();
        FileSystemResource resource = new FileSystemResource(file);
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("smfile", resource);
        HttpHeaders headers = getHttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(multiValueMap, headers);
        return restTemplate.postForObject(UPLOAD_URL, httpEntity, Result.class);
    }

    /**
     * get Headers
     *
     * @return headers
     */
    public static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return headers;
    }
}