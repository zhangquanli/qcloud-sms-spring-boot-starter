package com.github.zhangquanli.qcloud.sms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zhangquanli.qcloud.sms.http.AbstractResponse;

import java.util.List;

/**
 * GetSmsPackagesResponse
 *
 * @author zhangquanli
 */
public class GetSmsPackagesResponse extends AbstractResponse {

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<GetSmsPackagesData> getData() {
        return data;
    }

    public void setData(List<GetSmsPackagesData> data) {
        this.data = data;
    }
}
