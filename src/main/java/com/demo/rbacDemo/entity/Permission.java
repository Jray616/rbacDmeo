package com.demo.rbacDemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.demo.rbacDemo.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author jr
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("iw_permission")
@ApiModel(value="Permission对象", description="资源表")
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "权限名")
    private String name;

    @ApiModelProperty(value = "类型为菜单时，代表前端路由地址，类型为按钮时，代表后端接口地址")
    private String url;

    @ApiModelProperty(value = "权限类型，菜单-1，按钮-2")
    private Integer type;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "权限表达式")
    private String permission;

    @ApiModelProperty(value = "后端接口访问方式")
    private String method;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "父级id")
    private Long parentId;


}
