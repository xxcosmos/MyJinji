package me.xiaoyuu.inwust;

import com.alibaba.fastjson.JSON;
import me.xiaoyuu.inwust.dto.RawCourseInfo;
import me.xiaoyuu.inwust.model.CourseInfo;
import me.xiaoyuu.inwust.model.ProjectInfo;
import me.xiaoyuu.inwust.service.*;
import me.xiaoyuu.inwust.utils.CommonUtil;
import me.xiaoyuu.inwust.utils.CourseInfoUtil;
import me.xiaoyuu.inwust.utils.RestTemplate.RestTemplateUtil;
import me.xiaoyuu.inwust.utils.StudentInfoUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static me.xiaoyuu.inwust.utils.CourseInfoUtil.getCourseInfoList;
import static me.xiaoyuu.inwust.utils.CourseInfoUtil.gradeURL;

public class Parse extends Tester {

    @Resource
    StudentInfoService studentInfoService;
    @Resource
    MajorInfoService majorInfoService;
    @Resource
    CourseInfoService courseInfoService;
    @Resource
    CollegeInfoService collegeInfoService;
    @Resource
    StudentPicService studentPicService;
    public static final String BASE_URL = "https://cy.ncss.org.cn/search/projectlist?name=&industryCode=&wasBindUniTechnology=-9&investStageCode=&provinceCode=";
    public static final int PROJECT_NUM = 592896;
    @Resource
    ProjectInfoService projectInfoService;

    @Test
    public void getProject() {
        int pageSize = 3000;
        //  File file = new File(PATH_NAME);
        //  FileWriter fileWriter = new FileWriter(file);
        //  fileWriter.write("");
        RestTemplate restTemplate = null;
        try {
            restTemplate = RestTemplateUtil.getInstance();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        for (int k = 0; k < (PROJECT_NUM / pageSize) + 1; k++) {
            String listUrl = BASE_URL + "&pageIndex=" + k + "&pageSize=" + pageSize;
            assert restTemplate != null;
            String response = restTemplate.getForObject(listUrl, String.class);
            //   fileWriter.append(response);
            assert response != null;
            Document document = Jsoup.parse(response);
            Elements tr = document.select("tr[data-link]");
            for (Element e : tr) {
                ProjectInfo node = new ProjectInfo();
                Elements tds = e.getElementsByTag("td");
                String image;
                String text;
                for (int i = 0; i < tds.size(); i++) {
                    switch (i) {
                        case 0:
                            text = tds.get(i).getElementsByTag("span").get(0).text();
                            image = tds.get(i).getElementsByTag("img").get(0).attr("src");
                            node.setName(text);
                            node.setImage(image);
                            break;
                        case 1:
                            text = tds.get(i).getElementsByTag("div").get(0).text();
                            node.setIntroduction(text);
                            break;
                        case 2:
                            text = tds.get(i).getElementsByTag("span").get(0).text();
                            node.setField(text);
                            break;
                        case 3:
                            text = tds.get(i).text();
                            node.setLocal(text);
                            break;
                        case 4:
                            text = tds.get(i).getElementsByTag("span").get(0).text();
                            node.setIsCompany(!"否".equals(text));
                            break;
                        case 5:
                            text = tds.get(i).text();
                            node.setStatus(text);
                            break;
                        default:
                            System.out.println("error");
                    }
                }
                projectInfoService.save(node);
                System.out.println(node);
            }
        }
        //  fileWriter.close();
    }

    @Test
    public void test1() throws IOException {
        //  String filePath = "/Users/xiaoyuu/IdeaProjects/JustForFun/src/main/resources/project_list.txt";
        //   File file = new File(filePath);
        //  BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        //  StringBuilder stringBuilder = new StringBuilder();
        //  String line;
        //  while ((line = reader.readLine()) != null) {
        //      stringBuilder.append(line);
        //  }
        //  reader.close();

        //  String html = stringBuilder.toString();
//        Document document = Jsoup.parse(html);
//        Elements tr = document.select("tr[data-link]");
//        for (Element e : tr) {
//            ProjectInfo node = new ProjectInfo();
//            Elements tds = e.getElementsByTag("td");
//            String image;
//            String text;
//            for (int i = 0; i < tds.size(); i++) {
//                switch (i) {
//                    case 0:
//                        text = tds.get(i).getElementsByTag("span").get(0).text();
//                        image = tds.get(i).getElementsByTag("img").get(0).attr("src");
//                        node.setName(text);
//                        node.setImage(image);
//                        break;
//                    case 1:
//                        text = tds.get(i).getElementsByTag("div").get(0).text();
//                        node.setIntroduction(text);
//                        break;
//                    case 2:
//                        text = tds.get(i).getElementsByTag("span").get(0).text();
//                        node.setField(text);
//                        break;
//                    case 3:
//                        text = tds.get(i).text();
//                        node.setLocal(text);
//                        break;
//                    case 4:
//                        text = tds.get(i).getElementsByTag("span").get(0).text();
//                        node.setIsCompany(!"否".equals(text));
//                        break;
//                    case 5:
//                        text = tds.get(i).text();
//                        node.setStatus(text);
//                        break;
//                    default:
//                        System.out.println("error");
//                }
//            }
//            projectInfoService.save(node);
//            System.out.println(node);
//        }
    }

    @Test
    public void test22() {
        String url = gradeURL + "1";
        try {
            List<CourseInfo> courseInfoList = getCourseInfoList(url);
            for (CourseInfo courseInfo : courseInfoList) {
                courseInfoService.update(courseInfo);
            }

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        String url = gradeURL + "1";
        try {
            List<CourseInfo> courseInfoList = getCourseInfoList(url);
            courseInfoService.dbProcess(courseInfoList);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void test223() {

        try {
            String filePath = "/Users/xiaoyuu/IdeaProjects/my-springboot-seed-project/src/main/resources/static/AllClass.json";
            String s = CommonUtil.fileToString(filePath);
            System.out.println(s);

            List<CourseInfo> courseInfoList = CourseInfoUtil.getCourseInfoListFromJson(s);
            for (CourseInfo courseInfo : courseInfoList) {
                courseInfo.setUpdateTime(null);
                courseInfoService.update();
            }

            System.out.println(courseInfoList);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
