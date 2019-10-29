package com.github.zhangquanli.qcloud.sms.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetSmsPackagesRequest
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetSmsPackagesRequest {

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
}
