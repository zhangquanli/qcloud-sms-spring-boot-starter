package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GetSmsPackagesData
 *
 * @author zhangquanli
 */
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }
}
