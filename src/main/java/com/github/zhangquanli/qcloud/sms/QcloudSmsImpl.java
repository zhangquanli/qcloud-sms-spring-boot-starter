package com.github.zhangquanli.qcloud.sms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.zhangquanli.qcloud.sms.constants.QcloudSmsConstants;
import com.github.zhangquanli.qcloud.sms.request.*;
import com.github.zhangquanli.qcloud.sms.response.*;
import com.github.zhangquanli.qcloud.sms.utils.QcloudSmsUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * QcloudSmsImpl
 *
 * @author zhangquanli
 */
@Slf4j
public class QcloudSmsImpl implements QcloudSms {

    private Integer appId;
    private String appKey;
    private OkHttpClient okHttpClient;
    private ObjectMapper objectMapper;

    public QcloudSmsImpl(QcloudSmsProperties qcloudSmsProperties) {
        this.appId = qcloudSmsProperties.getAppId();
        this.appKey = qcloudSmsProperties.getAppKey();
        this.okHttpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public SendSingleSmsResponse sendSingleSms(SendSingleSmsRequest sendSingleSmsRequest) {
        Map<String, Object> params = QcloudSmsUtils.toMap(sendSingleSmsRequest);
        long time = QcloudSmsUtils.time();
        long random = QcloudSmsUtils.random(time);
        String sig = QcloudSmsUtils.sig(appKey, random, time, sendSingleSmsRequest.getTel().getMobile());
        params.put("time", time);
        params.put("sig", sig);
        String url = QcloudSmsConstants.SEND_SINGLE_SMS_URL +
                "?sdkappid=" + appId +
                "&random=" + random;
        String responseJson = post(url, params);
        return convert(responseJson, SendSingleSmsResponse.class);
    }

    @Override
    public SendMultiSmsResponse sendMultiSms(SendMultiSmsRequest sendMultiSmsRequest) {
        long time = QcloudSmsUtils.time();
        long random = QcloudSmsUtils.random(time);
        List<String> mobiles = sendMultiSmsRequest.getTels().stream()
                .map(Tel::getMobile)
                .collect(Collectors.toList());
        String sig = QcloudSmsUtils.sig(appKey, random, time, mobiles);
        Map<String, Object> params = QcloudSmsUtils.toMap(sendMultiSmsRequest);
        params.put("time", time);
        params.put("sig", sig);
        String url = QcloudSmsConstants.SEND_MULTI_SMS_URL +
                "?sdkappid=" + appId +
                "&random=" + random;
        String responseJson = post(url, params);
        return convert(responseJson, SendMultiSmsResponse.class);
    }

    @Override
    public PullSendStatusResponse pullSendStatus(PullSendStatusRequest pullSendStatusRequest) {
        long time = QcloudSmsUtils.time();
        long random = QcloudSmsUtils.random(time);
        String sig = QcloudSmsUtils.sig(appKey, random, time);
        Map<String, Object> params = QcloudSmsUtils.toMap(pullSendStatusRequest);
        params.put("time", time);
        params.put("sig", sig);
        String url = QcloudSmsConstants.PULL_SEND_STATUS_URL +
                "?sdkappid=" + appId +
                "&random=" + random;
        String responseJson = post(url, params);
        return convert(responseJson, PullSendStatusResponse.class);
    }

    @Override
    public PullCallbackStatusResponse pullCallbackStatus(PullCallbackStatusRequest pullCallbackStatusRequest) {
        long time = QcloudSmsUtils.time();
        long random = QcloudSmsUtils.random(time);
        String sig = QcloudSmsUtils.sig(appKey, random, time);
        Map<String, Object> params = QcloudSmsUtils.toMap(pullCallbackStatusRequest);
        params.put("time", time);
        params.put("sig", sig);
        String url = QcloudSmsConstants.PULL_CALLBACK_STATUS_URL +
                "?sdkappid=" + appId +
                "&random=" + random;
        String responseJson = post(url, params);
        return convert(responseJson, PullCallbackStatusResponse.class);
    }

    @Override
    public GetSmsPackagesResponse getSmsPackages(GetSmsPackagesRequest getSmsPackagesRequest) {
        long time = QcloudSmsUtils.time();
        long random = QcloudSmsUtils.random(time);
        String sig = QcloudSmsUtils.sig(appKey, random, time);
        Map<String, Object> params = QcloudSmsUtils.toMap(getSmsPackagesRequest);
        params.put("time", time);
        params.put("sig", sig);
        String url = QcloudSmsConstants.GET_SMS_PACKAGES_URL +
                "?sdkappid=" + appId +
                "&random=" + random;
        String responseJson = post(url, params);
        return convert(responseJson, GetSmsPackagesResponse.class);
    }

    private String post(String url, Map<String, Object> body) {
        String json;
        try {
            json = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        RequestBody requestBody = RequestBody.create(MediaType.get("application/json;charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        log.info("【腾讯云】>>>【短信】>>>请求数据>>>{}>>>{}", url, json);
        try (Response response = okHttpClient.newCall(request).execute();) {
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                throw new RuntimeException("【腾讯云短信服务】响应数据为空");
            }
            String responseJson = responseBody.string();
            log.info("【腾讯云】>>>【短信】>>>响应数据>>>{}", responseJson);
            return responseJson;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private <T> T convert(String json, Class<T> targetClass) {
        try {
            return objectMapper.readValue(json, targetClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
