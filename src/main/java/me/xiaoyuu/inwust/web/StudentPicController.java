package me.xiaoyuu.inwust.web;

import me.xiaoyuu.inwust.core.Result;
import me.xiaoyuu.inwust.core.ResultGenerator;
import me.xiaoyuu.inwust.dto.StudentInfoVO;
import me.xiaoyuu.inwust.model.CollegeInfo;
import me.xiaoyuu.inwust.model.MajorInfo;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.model.StudentPic;
import me.xiaoyuu.inwust.service.CollegeInfoService;
import me.xiaoyuu.inwust.service.MajorInfoService;
import me.xiaoyuu.inwust.service.StudentInfoService;
import me.xiaoyuu.inwust.service.StudentPicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.xiaoyuu.inwust.utils.CommonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/04/18.
 */
@RestController
@RequestMapping("/student/pic")
public class StudentPicController {
    @Resource
    private StudentPicService studentPicService;
    @Resource
    private StudentInfoService studentInfoService;
    @Resource
    private CollegeInfoService collegeInfoService;
    @Resource
    private MajorInfoService majorInfoService;

    @PostMapping
    public Result add(@RequestBody StudentPic studentPic) {
        studentPicService.save(studentPic);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        studentPicService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody StudentPic studentPic) {
        studentPicService.update(studentPic);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        StudentPic studentPic = studentPicService.findById(id);
        return ResultGenerator.genSuccessResult(studentPic);
    }

    @PostMapping("/query")
    public Result query(@RequestBody StudentInfo info) {
        System.out.println(info);
        String studentId = info.getStudentId();
        String studentName = info.getStudentName();
        if (studentId == null || studentName == null) {
            return ResultGenerator.genFailResult("无参数");
        }

        StudentInfo studentInfo = studentInfoService.findBy("studentId", info.getStudentId());

        if (studentInfo == null) {
            return ResultGenerator.genFailResult("不存在该学号对应的学生");
        }
        if (!info.getStudentName().equals(studentInfo.getStudentName())) {
            return ResultGenerator.genFailResult("姓名和学号不对应");
        }

        String url = CommonUtil.getStudentPicUrl(studentId);
        StudentInfoVO studentInfoVO = studentInfoService.getStudentInfoVo(studentName);
        studentInfoVO.setUrl(url);

        return ResultGenerator.genSuccessResult(studentInfoVO);


    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StudentPic> list = studentPicService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
