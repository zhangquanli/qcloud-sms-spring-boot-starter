package com.github.zhangquanli.qcloud.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.qcloud.sms.http.AbstractRequest;

import java.util.List;

/**
 * SendSingleSmsRequest
 *
 * @author zhangquanli
 */
public class SendSingleSmsRequest extends AbstractRequest {

    /**
     * 描述：国际电话号码
     * 是否必填：是
     */
    @JsonProperty("tel")
    private Tel tel;
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
    private String ext;
    /**
     * 描述：短信码号扩展号，格式为纯数字串，其他格式无效。默认没有开通，如需开通请联系 sms helper 。
     * 是否必填：否
     */
    @JsonProperty("extend")
    private String extend;

    private SendSingleSmsRequest(Tel tel, String sign, Long tplId, List<String> params, String ext, String extend) {
        this.tel = tel;
        this.sign = sign;
        this.tplId = tplId;
        this.params = params;
        this.ext = ext;
        this.extend = extend;
    }

    public Tel getTel() {
        return tel;
    }

    public String getSign() {
        return sign;
    }

    public Long getTplId() {
        return tplId;
    }

    public List<String> getParams() {
        return params;
    }

    public String getExt() {
        return ext;
    }

    public String getExtend() {
        return extend;
    }

    public static SendSingleSmsRequestBuilder builder() {
        return new SendSingleSmsRequestBuilder();
    }

    public static class SendSingleSmsRequestBuilder {

        private String mobile;
        private String nationCode;
        private String sign;
        private Long tplId;
        private List<String> params;
        private String ext;
        private String extend;

        private SendSingleSmsRequestBuilder() {
        }

        public SendSingleSmsRequestBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public SendSingleSmsRequestBuilder nationCode(String nationCode) {
            this.nationCode = nationCode;
            return this;
        }

        public SendSingleSmsRequestBuilder sign(String sign) {
            this.sign = sign;
            return this;
        }

        public SendSingleSmsRequestBuilder tplId(Long tplId) {
            this.tplId = tplId;
            return this;
        }

        public SendSingleSmsRequestBuilder params(List<String> params) {
            this.params = params;
            return this;
        }

        public SendSingleSmsRequestBuilder ext(String ext) {
            this.ext = ext;
            return this;
        }

        public SendSingleSmsRequestBuilder extend(String extend) {
            this.extend = extend;
            return this;
        }

        public SendSingleSmsRequest build() {
            Tel tel = Tel.builder().mobile(mobile).nationCode(nationCode).build();
            return new SendSingleSmsRequest(tel, sign, tplId, params, ext, extend);
        }
    }
}
