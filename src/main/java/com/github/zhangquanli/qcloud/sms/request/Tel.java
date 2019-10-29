package com.github.zhangquanli.qcloud.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Tel
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tel {

    /**
     * 描述：手机号码
     * 示例：13788888888
     * 是否必填：是
     */
    @JsonProperty("mobile")
    private String mobile;
    /**
     * 描述：国家（或地区）码
     * 示例：86
     * 是否必填：是
     */
    @JsonProperty("nationcode")
    private String nationCode;
}
