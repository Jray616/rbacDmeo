package com.demo.rbacDemo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 登录请求参数
 * </p>
 */
@Data
public class LoginRequest {

    /**
     * 用户名或邮箱或手机号
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String passWord;

    /**
     * 记住我
     */
    private Boolean rememberMe = false;

}
