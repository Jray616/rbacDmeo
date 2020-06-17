package com.demo.rbacDemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询 传输对象
 */
@Data
@ApiModel(value="PageDTO对象", description="分页查询 传输对象")
public class PageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前第几页，默认1")
    private int pageNum = 1;

    @ApiModelProperty(value = "每页显示条数，默认10")
    private int pageSize = 10;

}
