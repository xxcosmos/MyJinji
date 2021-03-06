package me.xiaoyuu.inwust.web;

import me.xiaoyuu.inwust.core.Result;
import me.xiaoyuu.inwust.core.ResultGenerator;
import me.xiaoyuu.inwust.model.CollegeInfo;
import me.xiaoyuu.inwust.service.CollegeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by xiaoyuu on 2019/04/12.
*/
@RestController
@RequestMapping("/college/info")
public class CollegeInfoController {
    @Resource
    private CollegeInfoService collegeInfoService;

    @PostMapping
    public Result add(@RequestBody CollegeInfo collegeInfo) {
        collegeInfoService.save(collegeInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        collegeInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody CollegeInfo collegeInfo) {
        collegeInfoService.update(collegeInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        CollegeInfo collegeInfo = collegeInfoService.findById(id);
        return ResultGenerator.genSuccessResult(collegeInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CollegeInfo> list = collegeInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
