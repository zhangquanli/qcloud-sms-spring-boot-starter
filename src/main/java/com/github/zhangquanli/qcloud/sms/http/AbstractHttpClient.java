package com.github.zhangquanli.qcloud.sms.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.zhangquanli.qcloud.sms.QcloudSmsProperties;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * AbstractHttpClient
 *
 * @author zhangquanli
 */
public abstract class AbstractHttpClient {
    private static final Logger log = LoggerFactory.getLogger(AbstractHttpClient.class);
    private Integer appId;
    private String appKey;
    private OkHttpClient okHttpClient;
    private ObjectMapper objectMapper;

    protected AbstractHttpClient(QcloudSmsProperties qcloudSmsProperties) {
        this.appId = qcloudSmsProperties.getAppId();
        this.appKey = qcloudSmsProperties.getAppKey();
        this.okHttpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    protected String postParamsJson(String api, AbstractRequest abstractRequest) {
        long random = random();
        long time = time();
        String sig = sig(random, time);
        return postParamsJson(api, abstractRequest, random, time, sig);
    }

    protected String postParamsJson(String api, AbstractRequest abstractRequest, String mobile) {
        long random = random();
        long time = time();
        String sig = sig(random, time, mobile);
        return postParamsJson(api, abstractRequest, random, time, sig);
    }

    protected String postParamsJson(String api, AbstractRequest abstractRequest, List<String> mobiles) {
        long random = random();
        long time = time();
        String sig = sig(random, time, mobiles);
        return postParamsJson(api, abstractRequest, random, time, sig);
    }

    protected <T extends AbstractResponse> T convert(String json, Class<T> targetClass) {
        try {
            return objectMapper.readValue(json, targetClass);
        } catch (JsonProcessingException e) {
            log.error("【腾讯云】>>>【短信】>>>数据转换异常", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    private String postParamsJson(String api, AbstractRequest abstractRequest, long random, long time, String sig) {
        // 请求地址
        String url = api + "?sdkappid=" + appId + "&random=" + random;
        // 请求数据
        abstractRequest.setTime(time);
        abstractRequest.setSig(sig);
        String json;
        try {
            json = objectMapper.writeValueAsString(abstractRequest);
        } catch (JsonProcessingException e) {
            String msg = "【腾讯云】>>>【短信】>>>数据转换异常";
            log.error(msg, e);
            throw new RuntimeException(msg);
        }
        // 构建请求数据
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        if (log.isDebugEnabled()) {
            log.debug("【腾讯云】>>>【短信】>>>请求地址：{}>>>请求数据：{}", url, json);
        }
        // 获取响应数据
        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String msg = "【腾讯云】>>>【短信】>>>响应状态异常";
                RuntimeException e = new RuntimeException(msg);
                log.error(msg, e);
                throw e;
            }
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                String msg = "【腾讯云】>>>【短信】>>>响应数据为空";
                RuntimeException e = new RuntimeException(msg);
                log.error(msg, e);
                throw e;
            }
            String responseJson = responseBody.string();
            if (log.isDebugEnabled()) {
                log.debug("【腾讯云】>>>【短信】>>>响应数据：{}", responseJson);
            }
            return responseJson;
        } catch (IOException e) {
            String msg = "【腾讯云】>>>【短信】>>>网络请求异常";
            log.error(msg, e);
            throw new RuntimeException(msg);
        }
    }

    private long time() {
        return System.currentTimeMillis() / 1000;
    }

    private long random() {
        Random random = new Random(System.currentTimeMillis() / 1000);
        return random.nextInt(900000) + 100000;
    }

    private String sig(long random, long time) {
        String data = "appkey=" + appKey +
                "&random=" + random +
                "&time=" + time;
        return DigestUtils.sha256Hex(data);
    }

    private String sig(long random, long time, String mobile) {
        String data = "appkey=" + appKey +
                "&random=" + random +
                "&time=" + time +
                "&mobile=" + mobile;
        return DigestUtils.sha256Hex(data);
    }

    private String sig(long random, long time, List<String> mobiles) {
        String data = "appkey=" + appKey +
                "&random=" + random +
                "&time=" + time +
                "&mobile=" + String.join(",", mobiles);
        return DigestUtils.sha256Hex(data);
    }
}
