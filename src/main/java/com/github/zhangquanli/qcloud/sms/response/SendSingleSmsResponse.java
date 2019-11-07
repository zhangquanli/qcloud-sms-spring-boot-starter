package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.qcloud.sms.http.AbstractResponse;

/**
 * SendSingleSmsResponse
 *
 * @author zhangquanli
 */
public class SendSingleSmsResponse extends AbstractResponse {

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
     * 描述：用户的 session 内容，腾讯 server 回包中会原样返回
     */
    @JsonProperty("ext")
    private String ext;
    /**
     * 描述：短信计费的条数
     */
    @JsonProperty("fee")
    private Integer fee;
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

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
