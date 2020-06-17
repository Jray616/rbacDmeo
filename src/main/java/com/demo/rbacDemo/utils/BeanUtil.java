package com.demo.rbacDemo.utils;

import java.util.Map;

public class BeanUtil extends cn.hutool.core.bean.BeanUtil {


    public static <T> T getToCamelCase(T bean, Object object) {

        Map<String, Object> map = beanToMap(object);

        return (T) fillBeanWithMap(map, bean, true, false);

    }



}
