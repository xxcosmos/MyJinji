package me.xiaoyuu.inwust.web;

import me.xiaoyuu.inwust.core.Result;
import me.xiaoyuu.inwust.core.ResultGenerator;
import me.xiaoyuu.inwust.dto.StudentInfoVO;
import me.xiaoyuu.inwust.model.CollegeInfo;
import me.xiaoyuu.inwust.model.MajorInfo;
import me.xiaoyuu.inwust.model.StudentInfo;
import me.xiaoyuu.inwust.service.CollegeInfoService;
import me.xiaoyuu.inwust.service.MajorInfoService;
import me.xiaoyuu.inwust.service.StudentInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by xiaoyuu on 2019/04/12.
*/
@RestController
@RequestMapping("/student/info")
public class StudentInfoController {
    @Resource
    private StudentInfoService studentInfoService;
    @Resource
    private MajorInfoService majorInfoService;
    @Resource
    private CollegeInfoService collegeInfoService;

    @PostMapping
    public Result add(@RequestBody StudentInfo studentInfo) {
        studentInfoService.save(studentInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        studentInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody StudentInfo studentInfo) {
        studentInfoService.update(studentInfo);
        return ResultGenerator.genSuccessResult();
    }

//    @GetMapping("/{id}")
//    public Result detail(@PathVariable Integer id) {
//        StudentInfo studentInfo = studentInfoService.findById(id);
//        return ResultGenerator.genSuccessResult(studentInfo);
//    }
    @GetMapping("/name/{name}")
    public Result FindStudentInfoByName(@PathVariable String name) {
        System.out.println(name);
        //查的是我
        if (name.equals("张啸宇")){
            return ResultGenerator.genSuccessResult(new StudentInfoVO(new StudentInfo("该人不存在哈哈哈哈哈哈😉",""),new MajorInfo(),new CollegeInfo()));
        }
        //同名的个数
        int num = studentInfoService.isExistByStudentName(name);
        if(num>1){
            return ResultGenerator.genSuccessResult(new StudentInfo("同名的有"+num+"个，请使用学号搜索。",""));
        }else if (num==1){
            StudentInfo studentInfo = studentInfoService.findBy("studentName",name);
            return ResultGenerator.genSuccessResult(new StudentInfoVO(studentInfo,majorInfoService.findById(studentInfo.getMajorId()),collegeInfoService.findById(studentInfo.getCollegeId())));
        }else {
            return ResultGenerator.genFailResult("查询不到");
        }
    }

    @GetMapping("/id/{id}")
    public Result findStudentInfoById(@PathVariable String id) {
        System.out.println(id);

        StudentInfo studentInfo = studentInfoService.findBy("studentId",id);
        if (studentInfo==null){
            return ResultGenerator.genFailResult("查询不到");
        }
        return ResultGenerator.genSuccessResult(new StudentInfoVO(studentInfo,majorInfoService.findById(studentInfo.getMajorId()),collegeInfoService.findById(studentInfo.getCollegeId())));
    }

//    @GetMapping
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<StudentInfo> list = studentInfoService.findAll();
//        PageInfo pageInfo = new PageInfo<>(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}
