package me.xiaoyuu.inwust.service.impl;

import me.xiaoyuu.inwust.dao.UserMapper;
import me.xiaoyuu.inwust.model.User;
import me.xiaoyuu.inwust.service.UserService;
import me.xiaoyuu.inwust.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/04/17.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
