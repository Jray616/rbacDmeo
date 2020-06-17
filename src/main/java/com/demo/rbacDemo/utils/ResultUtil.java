package com.demo.rbacDemo.utils;


import cn.hutool.core.lang.ParameterizedTypeImpl;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

import com.demo.rbacDemo.common.BaseException;
import com.demo.rbacDemo.common.Status;
import com.demo.rbacDemo.vo.PageVO;
import com.demo.rbacDemo.common.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;

import java.lang.reflect.Type;


/**
 * 响应结果工具类
 */
@Slf4j
public class ResultUtil {


    public static ApiResponse successPagesVO(PageImpl data) {

        PageVO pageVo = new PageVO<>();
        pageVo.setDataList(data.getContent());
        pageVo.setPageNumber(data.getNumber() + 1);
        pageVo.setTotalPage(data.getTotalPages());
        pageVo.setTotalNumber(data.getTotalElements());

        return ApiResponse.ofSuccess(pageVo);
    }





}
