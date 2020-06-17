package com.demo.rbacDemo.service.impl;

import com.demo.rbacDemo.entity.User;
import com.demo.rbacDemo.mapper.UserMapper;
import com.demo.rbacDemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jr
 * @since 2020-06-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
