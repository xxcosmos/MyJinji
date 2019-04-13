package me.xiaoyuu.inwust.utils;

import me.xiaoyuu.inwust.utils.RestTemplate.RestTemplateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommonUtil {

    private static String baseUrl = "http://jwxt.wust.edu.cn/whkjdx/uploadfile/studentphoto/pic/";
    private static String basePath = "/Users/xiaoyuu/WUSTStudentPic/";

    private static void saveFile(String pathName, String fileName, byte[] data) {
        //判断文件夹是否存在
        File path = new File(pathName);
        if (!path.exists()) {
            path.mkdirs();
        }
        //判断文件是否存在
        File file = new File(pathName + fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            //写入文件
            OutputStream outputStream = new FileOutputStream(pathName + fileName);
            outputStream.write(data);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static int getPicture(String studentId) {
        String fileName = studentId + ".JPG";
        String url = baseUrl + fileName;
        String pathName = basePath + studentId.substring(4, 6) + "/" + studentId.substring(0, 4) + "/";
        //新建RestTemplate,将图片读入bytes中
        RestTemplate restTemplate = RestTemplateUtil.getInstance();
        ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class);
        byte[] data = responseEntity.getBody();

        if (data != null && responseEntity.getStatusCode().is2xxSuccessful()) {
            saveFile(pathName, fileName, data);
            return 0;
        } else {
            return 1;
        }
    }

    public static void generator() {
        String grade = "2017";
        List<String> collegeCode = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            collegeCode.add((i < 10) ? ("0" + i) : String.valueOf(i));
        }
        String major = "00-26";
        String num = "001-500";



    }


    public static void main(String[] args) {
        getPicture("201913137042");
//        String studentId ="201713137041";
//        String pathName = " /Users/xiaoyuu/wustStudentPic/"+studentId.substring(4,6)+"/"+studentId.substring(0,4)+"/";
//        File file = new File(pathName+studentId+".JPG");
//        try {
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
//            int read = bufferedInputStream.read();
//            System.out.println(read);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }
}
