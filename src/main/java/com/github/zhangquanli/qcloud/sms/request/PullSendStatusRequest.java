package com.github.zhangquanli.qcloud.sms.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PullSendStatus
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PullSendStatusRequest {

    /**
     * 描述：开始时间，yyyymmddhh 需要拉取的起始时间，精确到小时
     * 示例：2016090800
     * 是否必填：是
     */
    @JsonProperty("begin_date")
    private Integer beginDate;
    /**
     * 描述：结束时间，yyyymmddhh 需要拉取的截止时间，精确到小时
     * 示例：2016090823
     * 是否必填：是
     */
    @JsonProperty("end_date")
    private Integer endDate;
}
