package com.github.zhangquanli.qcloud.sms;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * QcloudSmsProperties
 *
 * @author zhangquanli
 */
@ConfigurationProperties(prefix = "qcloud.sms")
public class QcloudSmsProperties {

    private Integer appId;
    private String appKey;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
