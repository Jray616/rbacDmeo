package com.demo.rbacDemo.service;

import com.demo.rbacDemo.entity.Role;
import com.demo.rbacDemo.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author jr
 * @since 2020-06-17
 */
public interface UserRoleService extends IService<UserRole> {

    List<Role> listRoleByUserId(String userId);

}
