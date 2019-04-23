package me.xiaoyuu.inwust.web;

import me.xiaoyuu.inwust.core.Result;
import me.xiaoyuu.inwust.core.ResultGenerator;
import me.xiaoyuu.inwust.model.ProjectInfo;
import me.xiaoyuu.inwust.service.ProjectInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/04/23.
 */
@RestController
@RequestMapping("/project/info")
public class ProjectInfoController {
    @Resource
    private ProjectInfoService projectInfoService;

    @PostMapping
    public Result add(@RequestBody ProjectInfo projectInfo) {
        projectInfoService.save(projectInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        projectInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ProjectInfo projectInfo) {
        projectInfoService.update(projectInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        ProjectInfo projectInfo = projectInfoService.findById(id);
        return ResultGenerator.genSuccessResult(projectInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ProjectInfo> list = projectInfoService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
