package com.demo.rbacDemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.demo.rbacDemo.entity.Permission;
import com.demo.rbacDemo.entity.Role;
import com.demo.rbacDemo.entity.User;
import com.demo.rbacDemo.entity.UserPrincipal;
import com.demo.rbacDemo.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 自定义UserDetails查询
 * </p>
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmailOrPhone) throws UsernameNotFoundException {

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name", usernameOrEmailOrPhone);
        User user = userService.getOne(userQueryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("未找到用户信息 : " + usernameOrEmailOrPhone);
        }
        List<Role> roles = userRoleService.listRoleByUserId(user.getId());

        List<String> roleIds = roles.stream()
                .map(Role::getId)
                .collect(Collectors.toList());
        List<Permission> permissions = permissionMapper.listPermissionByRoleId(roleIds);
        return UserPrincipal.create(user, roles, permissions);
    }
}
