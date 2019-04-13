package me.xiaoyuu.inwust.service.impl;

import me.xiaoyuu.inwust.dao.MajorInfoMapper;
import me.xiaoyuu.inwust.model.MajorInfo;
import me.xiaoyuu.inwust.service.MajorInfoService;
import me.xiaoyuu.inwust.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/04/12.
 */
@Service
@Transactional
public class MajorInfoServiceImpl extends AbstractService<MajorInfo> implements MajorInfoService {
    @Resource
    private MajorInfoMapper majorInfoMapper;

}
