package me.xiaoyuu.inwust.service.impl;

import me.xiaoyuu.inwust.dao.ProjectInfoMapper;
import me.xiaoyuu.inwust.model.ProjectInfo;
import me.xiaoyuu.inwust.service.ProjectInfoService;
import me.xiaoyuu.inwust.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/04/23.
 */
@Service
@Transactional
public class ProjectInfoServiceImpl extends AbstractService<ProjectInfo> implements ProjectInfoService {
    @Resource
    private ProjectInfoMapper projectInfoMapper;

}
