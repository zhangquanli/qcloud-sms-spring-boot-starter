package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PullSendStatusData
 *
 * @author zhangquanli
 */
public class PullSendStatusData {

    /**
     * 描述：短信计费条数，例如提交成功量为100条，其中有20条是长短信（长度为80字）被拆分成2条，则计费条数为： 80 * 1 + 20 * 2 = 120 条
     */
    @JsonProperty("bill_number")
    private Integer billNumber;
    /**
     * 描述：短信提交量
     */
    @JsonProperty("request")
    private Integer request;
    /**
     * 描述：短信提交成功量
     */
    @JsonProperty("success")
    private Integer success;

    public Integer getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(Integer billNumber) {
        this.billNumber = billNumber;
    }

    public Integer getRequest() {
        return request;
    }

    public void setRequest(Integer request) {
        this.request = request;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }
}
