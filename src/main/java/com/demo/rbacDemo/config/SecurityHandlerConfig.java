package com.demo.rbacDemo.config;


import com.demo.rbacDemo.common.Status;
import com.demo.rbacDemo.utils.ResponseUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;


/**
 * <p>
 * Security 结果处理配置
 * </p>
 */
@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> ResponseUtil.renderJson(response, Status.ACCESS_DENIED, null);
    }

}
