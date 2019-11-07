package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.qcloud.sms.http.AbstractResponse;

/**
 * PullCallbackStatusResponse
 *
 * @author zhangquanli
 */
public class PullCallbackStatusResponse extends AbstractResponse {

    /**
     * 描述：错误码，0表示成功（计费依据），非0表示失败
     */
    @JsonProperty("result")
    private Integer result;
    /**
     * 描述：消息
     */
    @JsonProperty("msg")
    private String msg;
    /**
     * 描述：错误消息，result 非0时的具体错误信息
     */
    @JsonProperty("errmsg")
    private String errMsg;
    /**
     * 描述：应答数据
     */
    @JsonProperty("data")
    private PullCallbackStatusData data;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public PullCallbackStatusData getData() {
        return data;
    }

    public void setData(PullCallbackStatusData data) {
        this.data = data;
    }
}
