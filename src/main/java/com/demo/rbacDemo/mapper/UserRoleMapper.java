package com.demo.rbacDemo.mapper;

import com.demo.rbacDemo.entity.Role;
import com.demo.rbacDemo.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author jr
 * @since 2020-06-17
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<Role> listRoleByUserId(String userId);

}
