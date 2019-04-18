package me.xiaoyuu.inwust.service.impl;

import me.xiaoyuu.inwust.dao.StudentPicMapper;
import me.xiaoyuu.inwust.model.StudentPic;
import me.xiaoyuu.inwust.service.StudentPicService;
import me.xiaoyuu.inwust.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/04/18.
 */
@Service
@Transactional
public class StudentPicServiceImpl extends AbstractService<StudentPic> implements StudentPicService {
    @Resource
    private StudentPicMapper studentPicMapper;

}
