package com.aciel.reggie.service.impl;

import com.aciel.reggie.entity.User;
import com.aciel.reggie.mapper.UserMapper;
import com.aciel.reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
