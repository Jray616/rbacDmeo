package com.demo.rbacDemo.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.demo.rbacDemo.common.BaseException;
import com.demo.rbacDemo.common.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * http请求工具类
 */
@Slf4j
@Component
public class MyHttpUtil {


    /**
     * 从 request 的 header 中获取 JWT
     *
     * @return JWT
     */
    public String getJwtFromRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }
        HttpServletRequest request = requestAttributes.getRequest();

        String bearerToken = request.getHeader("Authorization");
        if (StrUtil.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }



    /**
     * post请求
     * @param url
     * @param param
     * @return
     */
    public  String post(String url, Map<String, Object> param) {

        String jwtFromRequest = getJwtFromRequest();

        String body = HttpRequest.post(url)
                .header("Authorization", "Bearer " + jwtFromRequest)
                .form(param)
                .timeout(20000)//超时，毫秒
                .execute().body();
        return body;
    }

    /**
     * get 请求
     * @param url
     * @param param
     * @return
     */
    public  String get(String url,Map<String, Object> param) {

        String jwtFromRequest = getJwtFromRequest();

        String body = HttpRequest.get(url)
                .header("Authorization", "Bearer " + jwtFromRequest)
                .form(param)
                .timeout(20000)//超时，毫秒
                .execute()
                .body();

        return body;
    }




}
