package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SendMultiSmsDetail
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
