package com.demo.rbacDemo.service.impl;

import com.demo.rbacDemo.entity.Role;
import com.demo.rbacDemo.mapper.RoleMapper;
import com.demo.rbacDemo.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author jr
 * @since 2020-06-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
