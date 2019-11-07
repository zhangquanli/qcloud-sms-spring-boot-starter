package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PullCallbackStatusData
 *
 * @author zhangquanli
 */
public class PullCallbackStatusData {

    /**
     * 描述：短信回执量
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * 描述：短信回执失败量
     */
    @JsonProperty("status_fail")
    private Integer statusFail;
    /**
     * 描述：运营商内部错误
     */
    @JsonProperty("status_fail_0")
    private Integer statusFail0;
    /**
     * 描述：号码无效或空号
     */
    @JsonProperty("status_fail_1")
    private Integer statusFail1;
    /**
     * 描述：停机、关机等
     */
    @JsonProperty("status_fail_2")
    private Integer statusFail2;
    /**
     * 描述：黑名单
     */
    @JsonProperty("status_fail_3")
    private Integer statusFail3;
    /**
     * 描述：运营商频率限制
     */
    @JsonProperty("status_fail_4")
    private Integer statusFail4;
    /**
     * 描述：短信回执成功量
     */
    @JsonProperty("status_success")
    private Integer statusSuccess;
    /**
     * 描述：短信提交成功量
     */
    @JsonProperty("success")
    private Integer success;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatusFail() {
        return statusFail;
    }

    public void setStatusFail(Integer statusFail) {
        this.statusFail = statusFail;
    }

    public Integer getStatusFail0() {
        return statusFail0;
    }

    public void setStatusFail0(Integer statusFail0) {
        this.statusFail0 = statusFail0;
    }

    public Integer getStatusFail1() {
        return statusFail1;
    }

    public void setStatusFail1(Integer statusFail1) {
        this.statusFail1 = statusFail1;
    }

    public Integer getStatusFail2() {
        return statusFail2;
    }

    public void setStatusFail2(Integer statusFail2) {
        this.statusFail2 = statusFail2;
    }

    public Integer getStatusFail3() {
        return statusFail3;
    }

    public void setStatusFail3(Integer statusFail3) {
        this.statusFail3 = statusFail3;
    }

    public Integer getStatusFail4() {
        return statusFail4;
    }

    public void setStatusFail4(Integer statusFail4) {
        this.statusFail4 = statusFail4;
    }

    public Integer getStatusSuccess() {
        return statusSuccess;
    }

    public void setStatusSuccess(Integer statusSuccess) {
        this.statusSuccess = statusSuccess;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }
}
