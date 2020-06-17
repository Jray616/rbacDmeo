package com.demo.rbacDemo.service.impl;

import com.demo.rbacDemo.entity.Role;
import com.demo.rbacDemo.entity.UserRole;
import com.demo.rbacDemo.mapper.UserRoleMapper;
import com.demo.rbacDemo.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author jr
 * @since 2020-06-17
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public List<Role> listRoleByUserId(String userId) {
        List<Role> roles = userRoleMapper.listRoleByUserId(userId);
        return roles;
    }
}
