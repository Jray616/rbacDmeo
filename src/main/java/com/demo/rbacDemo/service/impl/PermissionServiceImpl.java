package com.demo.rbacDemo.service.impl;

import com.demo.rbacDemo.entity.Permission;
import com.demo.rbacDemo.mapper.PermissionMapper;
import com.demo.rbacDemo.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author jr
 * @since 2020-06-17
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
