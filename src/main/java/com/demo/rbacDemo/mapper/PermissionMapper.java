package com.demo.rbacDemo.mapper;

import com.demo.rbacDemo.entity.Permission;
import com.demo.rbacDemo.vo.PermissionTree;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author jr
 * @since 2020-06-17
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> listPermissionByRoleId(List<String> roleIds);

    /**
     * 获取用户的所有权限
     * @param userId
     * @return
     */
    List<Permission> listPermissionByUserId(String userId);


    /**
     * 列表资源
     *
     * @param delFlag
     * @return
     */
    List<PermissionTree> listPermission(int delFlag);


    PermissionTree findPermissionByPid(Map<String, Object> param);

}
