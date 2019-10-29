package com.github.zhangquanli.qcloud.sms.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SendMultiSmsRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMultiSmsRequest {

    /**
     * 描述：群发号码数组，群发时一次最多不要超过200个手机号
     * 是否必填：是
     */
    @JsonProperty("tel")
    private List<Tel> tels;
    /**
     * 描述：短信签名内容
     * 示例：腾讯云
     * 是否必填：是
     */
    @JsonProperty("sign")
    private String sign;
    /**
     * 描述：模板ID
     * 示例：19
     * 是否必填：是
     */
    @JsonProperty("tpl_id")
    private Long tplId;
    /**
     * 描述：模板参数，具体使用方法请参见下方说明。若模板没有参数，请设置为空数组。
     * 示例：["验证码", "1234","4"]
     * 是否必填：是
     */
    @JsonProperty("params")
    private List<String> params;
    /**
     * 描述：用户的 session 内容，腾讯 server 回包中会原样返回，可选字段，不需要时设置为空。
     * 是否必填：否
     */
    @JsonProperty("ext")
    private String ext = "";
    /**
     * 描述：短信码号扩展号，格式为纯数字串，其他格式无效。默认没有开通，如需开通请联系 sms helper 。
     * 是否必填：否
     */
    @JsonProperty("extend")
    private String extend = "";
}
