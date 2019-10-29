package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SendMultiSmsResponse
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendMultiSmsResponse {

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
     * 描述：结果详细
     */
    @JsonProperty("detail")
    private List<SendMultiSmsDetail> details;
}
