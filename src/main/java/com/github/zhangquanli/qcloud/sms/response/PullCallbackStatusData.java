package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PullCallbackStatusData
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PullCallbackStatusData {

    /**
     * 描述：短信回执量
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * 描述：短信回执失败量
     */
    @JsonProperty("status_fail")
    private Integer statusFail;
    /**
     * 描述：运营商内部错误
     */
    @JsonProperty("status_fail_0")
    private Integer statusFail0;
    /**
     * 描述：号码无效或空号
     */
    @JsonProperty("status_fail_1")
    private Integer statusFail1;
    /**
     * 描述：停机、关机等
     */
    @JsonProperty("status_fail_2")
    private Integer statusFail2;
    /**
     * 描述：黑名单
     */
    @JsonProperty("status_fail_3")
    private Integer statusFail3;
    /**
     * 描述：运营商频率限制
     */
    @JsonProperty("status_fail_4")
    private Integer statusFail4;
    /**
     * 描述：短信回执成功量
     */
    @JsonProperty("status_success")
    private Integer statusSuccess;
    /**
     * 描述：短信提交成功量
     */
    @JsonProperty("success")
    private Integer success;
}
