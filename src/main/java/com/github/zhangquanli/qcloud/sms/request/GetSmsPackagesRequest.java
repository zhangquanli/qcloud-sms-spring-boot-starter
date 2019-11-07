package com.github.zhangquanli.qcloud.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.qcloud.sms.http.AbstractRequest;

/**
 * GetSmsPackagesRequest
 *
 * @author zhangquanli
 */
public class GetSmsPackagesRequest extends AbstractRequest {

    /**
     * 描述：分页拉取的偏移量
     * 示例：0
     * 是否必填：是
     */
    @JsonProperty("offset")
    private Integer offset;
    /**
     * 描述：每次拉取的套餐包个数
     * 示例：10
     * 是否必填：是
     */
    @JsonProperty("length")
    private Integer length;

    private GetSmsPackagesRequest(Integer offset, Integer length) {
        this.offset = offset;
        this.length = length;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLength() {
        return length;
    }

    public static GetSmsPackagesRequestBuilder builder() {
        return new GetSmsPackagesRequestBuilder();
    }

    public static class GetSmsPackagesRequestBuilder {

        private Integer offset;
        private Integer length;

        private GetSmsPackagesRequestBuilder() {
        }

        public GetSmsPackagesRequestBuilder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public GetSmsPackagesRequestBuilder length(Integer length) {
            this.length = length;
            return this;
        }

        public GetSmsPackagesRequest build() {
            return new GetSmsPackagesRequest(offset, length);
        }
    }
}
