package com.github.zhangquanli.qcloud.sms.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.codec.digest.DigestUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * QcloudSmsUtils
 *
 * @author zhangquanli
 */
public class QcloudSmsUtils {

    public static long time() {
        return System.currentTimeMillis() / 1000;
    }

    public static long random(long time) {
        Random random = new Random(time);
        return random.nextInt(900000) + 100000;
    }

    public static String sig(String appKey, long random, long time) {
        String params = "appkey=" + appKey +
                "&random=" + random +
                "&time=" + time;
        return DigestUtils.sha256Hex(params);
    }

    public static String sig(String appKey, long random, long time, String mobile) {
        String params = "appkey=" + appKey +
                "&random=" + random +
                "&time=" + time +
                "&mobile=" + mobile;
        return DigestUtils.sha256Hex(params);
    }

    public static String sig(String appKey, long random, long time, List<String> mobiles) {
        String params = "appkey=" + appKey +
                "&random=" + random +
                "&time=" + time +
                "&mobile=" + String.join(",", mobiles);
        return DigestUtils.sha256Hex(params);
    }

    public static Map<String, Object> toMap(Object obj) {
        Class<?> sourceClass = obj.getClass();
        Map<String, Object> map = new HashMap<>(sourceClass.getDeclaredAnnotations().length);
        for (Field field : sourceClass.getDeclaredFields()) {
            JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
            String key = jsonProperty.value();
            if ("class".equals(key)) {
                continue;
            }
            Object value;
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), sourceClass);
                value = pd.getReadMethod().invoke(obj);
                if (value == null) {
                    continue;
                }
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                continue;
            }
            map.put(key, value);
        }
        return map;
    }
}
