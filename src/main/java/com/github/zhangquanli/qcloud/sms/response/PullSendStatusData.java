package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PullSendStatusData
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PullSendStatusData {

    /**
     * 描述：短信计费条数，例如提交成功量为100条，其中有20条是长短信（长度为80字）被拆分成2条，则计费条数为： 80 * 1 + 20 * 2 = 120 条
     */
    @JsonProperty("bill_number")
    private Integer billNumber;
    /**
     * 描述：短信提交量
     */
    @JsonProperty("request")
    private Integer request;
    /**
     * 描述：短信提交成功量
     */
    @JsonProperty("success")
    private Integer success;
}
