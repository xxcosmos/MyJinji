package me.xiaoyuu.inwust.web;

import me.xiaoyuu.inwust.core.Result;
import me.xiaoyuu.inwust.core.ResultGenerator;
import me.xiaoyuu.inwust.model.MajorInfo;
import me.xiaoyuu.inwust.service.MajorInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by xiaoyuu on 2019/04/12.
*/
@RestController
@RequestMapping("/major/info")
public class MajorInfoController {
    @Resource
    private MajorInfoService majorInfoService;

    @PostMapping
    public Result add(@RequestBody MajorInfo majorInfo) {
        majorInfoService.save(majorInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        majorInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody MajorInfo majorInfo) {
        majorInfoService.update(majorInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        MajorInfo majorInfo = majorInfoService.findById(id);
        return ResultGenerator.genSuccessResult(majorInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MajorInfo> list = majorInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
