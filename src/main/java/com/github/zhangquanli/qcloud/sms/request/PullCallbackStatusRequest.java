package com.github.zhangquanli.qcloud.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.qcloud.sms.http.AbstractRequest;

/**
 * PullCallbackStatusRequest
 *
 * @author zhangquanli
 */
public class PullCallbackStatusRequest extends AbstractRequest {

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

    private PullCallbackStatusRequest(Integer beginDate, Integer endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public static PullCallbackStatusRequestBuilder builder() {
        return new PullCallbackStatusRequestBuilder();
    }

    public static class PullCallbackStatusRequestBuilder {

        private Integer beginDate;
        private Integer endDate;

        private PullCallbackStatusRequestBuilder() {
        }

        public PullCallbackStatusRequestBuilder beginDate(Integer beginDate) {
            this.beginDate = beginDate;
            return this;
        }

        public PullCallbackStatusRequestBuilder endDate(Integer endDate) {
            this.endDate = endDate;
            return this;
        }

        public PullCallbackStatusRequest build() {
            return new PullCallbackStatusRequest(beginDate, endDate);
        }
    }
}
