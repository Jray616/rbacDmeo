package com.demo.rbacDemo.entity.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 实体基础类
 * </p>
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建时间")
    private long createTime = System.currentTimeMillis();

    @ApiModelProperty(value = "修改时间")
    private long updateTime = System.currentTimeMillis();

    @ApiModelProperty(value = "删除标识 0-正常 1-删除")
    private Integer delFlag;

    /**
     * 设置默认创建时间和更新时间
     */
    public void setTime() {
        long currentTimeMillis = System.currentTimeMillis();
        this.createTime = currentTimeMillis;
        this.updateTime = currentTimeMillis;
    }
}
