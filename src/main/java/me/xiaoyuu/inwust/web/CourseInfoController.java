package me.xiaoyuu.inwust.web;

import me.xiaoyuu.inwust.core.Result;
import me.xiaoyuu.inwust.core.ResultGenerator;
import me.xiaoyuu.inwust.model.CourseInfo;
import me.xiaoyuu.inwust.service.CourseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/04/27.
 */
@RestController
@RequestMapping("/course/info")
public class CourseInfoController {
    @Resource
    private CourseInfoService courseInfoService;

//    @PostMapping
//    public Result add(@RequestBody CourseInfo courseInfo) {
//        courseInfoService.save(courseInfo);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @DeleteMapping("/{id}")
//    public Result delete(@PathVariable Integer id) {
//        courseInfoService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PutMapping
//    public Result update(@RequestBody CourseInfo courseInfo) {
//        courseInfoService.update(courseInfo);
//        return ResultGenerator.genSuccessResult();
//    }

    /**
     * 得到课程列表
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CourseInfo> list = courseInfoService.findAll();
        PageInfo<CourseInfo> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 得到id为id的课程信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        CourseInfo courseInfo = courseInfoService.findById(id);
        if (courseInfo.getCourseCode() == null) {
            return ResultGenerator.genFailResult("找不到该课程");

        }
        return ResultGenerator.genSuccessResult(courseInfo);
    }


    /**
     * 通过学院代码得到该学院的所有课程
     *
     * @param collegeCode
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search/college/{collegeCode}")
    public Result searchByCollegeCode(@PathVariable Integer collegeCode, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //如果小于10，则加上前导0
        String collegeCodeStr = (collegeCode < 10) ? "0" + collegeCode.toString() : collegeCode.toString();
        PageHelper.startPage(page, size);
        List<CourseInfo> courseInfoList = courseInfoService.getByCollegeCode(collegeCodeStr);
        PageInfo<CourseInfo> pageInfo = new PageInfo<>(courseInfoList);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 通过关键词模糊搜索课程
     *
     * @param keyword
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search/keyword/{keyword}")
    public Result searchByKeyword(@PathVariable String keyword, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CourseInfo> searchCourseNameResult = courseInfoService.getByCourseName(keyword);
        List<CourseInfo> searchTeacherNameResult = courseInfoService.getByTeacherName(keyword);
        List<CourseInfo> courseInfoList = new ArrayList<>(searchCourseNameResult);
        courseInfoList.addAll(searchTeacherNameResult);
        if (courseInfoList.size() == 0) {
            return ResultGenerator.genFailResult("搜索不到含有关键字为" + keyword + "的课程。");

        } else {
            PageInfo pageInfo = new PageInfo<>(courseInfoList);
            return ResultGenerator.genSuccessResult(pageInfo);
        }
    }
//
//    @GetMapping("/search/teacher_name/{keyword}")
//    public Result searchByTeacherName(@PathVariable String keyword) {
//        System.out.println(keyword);
//        List<CourseInfo> courseInfoList = courseInfoService.getByTeacherName(keyword);
//        if (courseInfoList.size() == 0) {
//            return ResultGenerator.genFailResult("搜索不到含有 " + keyword + " 的老师。");
//
//        }
//        return ResultGenerator.genSuccessResult(courseInfoList);
//    }
}
