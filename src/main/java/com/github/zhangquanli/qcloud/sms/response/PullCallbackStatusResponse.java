package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PullCallbackStatusResponse
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PullCallbackStatusResponse {

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
}
