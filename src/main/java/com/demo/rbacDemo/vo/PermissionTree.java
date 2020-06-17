package com.demo.rbacDemo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value="系统菜单树", description="系统菜单树")
public class PermissionTree implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "权限名")
    private String name;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "类型为菜单时，代表前端路由地址，类型为按钮时，代表后端接口地址")
    private String url;

    @ApiModelProperty(value = "权限类型，菜单-1，按钮-2")
    private Integer type;

    @ApiModelProperty(value = "权限表达式")
    private String permission;

    @ApiModelProperty(value = "后端接口访问方式")
    private String method;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "父级id 0-表示根节点")
    private Long parentId;

    @ApiModelProperty(value = "子菜单")
    private List<PermissionTree> children;


}
