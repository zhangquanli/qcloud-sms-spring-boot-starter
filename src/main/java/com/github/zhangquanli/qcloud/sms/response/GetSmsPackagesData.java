package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetSmsPackagesData
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSmsPackagesData {

    /**
     * 描述：套餐包创建时间
     */
    @JsonProperty("create_time")
    private String createTime;
    /**
     * 描述：套餐包生效时间
     */
    @JsonProperty("from_time")
    private String fromTime;
    /**
     * 描述：套餐包过期时间
     */
    @JsonProperty("to_time")
    private String toTime;
    /**
     * 描述：套餐包条数
     */
    @JsonProperty("amount")
    private Integer amount;
    /**
     * 描述：0表示赠送套餐包，1表示购买套餐包
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * 描述：套餐包 ID
     */
    @JsonProperty("package_id")
    private Integer packageId;
    /**
     * 描述：当前使用量
     */
    @JsonProperty("used")
    private Integer used;
}
