package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * GetSmsPackagesResponse
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSmsPackagesResponse {

    /**
     * 描述：套餐包个数
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * 描述：套餐包详情
     */
    @JsonProperty("data")
    private List<GetSmsPackagesData> data;
}
