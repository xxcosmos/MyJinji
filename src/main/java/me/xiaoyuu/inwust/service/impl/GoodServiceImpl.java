package me.xiaoyuu.inwust.service.impl;

import me.xiaoyuu.inwust.dao.GoodMapper;
import me.xiaoyuu.inwust.model.Good;
import me.xiaoyuu.inwust.service.GoodService;
import me.xiaoyuu.inwust.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/04/10.
 */
@Service
@Transactional
public class GoodServiceImpl extends AbstractService<Good> implements GoodService {
    @Resource
    private GoodMapper goodMapper;

}
