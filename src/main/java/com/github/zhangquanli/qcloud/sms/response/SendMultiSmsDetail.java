package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SendMultiSmsDetail
 *
 * @author zhangquanli
 */
public class SendMultiSmsDetail {

    /**
     * 描述：错误码，0表示成功（计费依据），非0表示失败
     */
    @JsonProperty("result")
    private Integer result;
    /**
     * 描述：错误消息，result 非0时的具体错误信息
     */
    @JsonProperty("errmsg")
    private String errMsg;
    /**
     * 描述：短信计费的条数
     */
    @JsonProperty("fee")
    private Integer fee;
    /**
     * 描述：手机号码
     */
    @JsonProperty("mobile")
    private String mobile;
    /**
     * 描述：国家码
     */
    @JsonProperty("nationcode")
    private String nationCode;
    /**
     * 描述：本次发送标识 ID，标识一次短信下发记录
     */
    @JsonProperty("sid")
    private String sid;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
