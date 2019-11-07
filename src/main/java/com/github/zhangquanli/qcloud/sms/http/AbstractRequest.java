package com.github.zhangquanli.qcloud.sms.http;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AbstractRequest
 *
 * @author zhangquanli
 */
public abstract class AbstractRequest {

    /**
     * 描述：请求发起时间，UNIX 时间戳（单位：秒），如果和系统时间相差超过 10 分钟则会返回失败
     * 示例：1457336869
     * 是否必填：是
     */
    @JsonProperty("time")
    private Long time;
    /**
     * 描述：App 凭证
     * 示例：ecab4881ee80ad3d76bb1da68387428ca752eb885e52621a3129dcf4d9bc4fd4
     * 是否必填：是
     */
    @JsonProperty("sig")
    private String sig;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }
}
