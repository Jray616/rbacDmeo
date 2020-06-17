package com.demo.rbacDemo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "分页VO")
public class PageVO<T> {

    @ApiModelProperty(notes = "总数")
    private long totalNumber;

    @ApiModelProperty(notes = "总页数")
    private int totalPage;

    @ApiModelProperty(notes = "当前页数")
    private int pageNumber;

    @ApiModelProperty(notes = "数据集合")
    private List<T> dataList;

}
