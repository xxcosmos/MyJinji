package me.xiaoyuu.inwust.service.impl;

import me.xiaoyuu.inwust.dao.CollegeInfoMapper;
import me.xiaoyuu.inwust.model.CollegeInfo;
import me.xiaoyuu.inwust.service.CollegeInfoService;
import me.xiaoyuu.inwust.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/04/12.
 */
@Service
@Transactional
public class CollegeInfoServiceImpl extends AbstractService<CollegeInfo> implements CollegeInfoService {
    @Resource
    private CollegeInfoMapper collegeInfoMapper;

}
