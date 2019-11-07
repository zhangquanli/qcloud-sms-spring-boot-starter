package com.github.zhangquanli.qcloud.sms.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Tel
 *
 * @author zhangquanli
 */
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

    private Tel(String mobile, String nationCode) {
        this.mobile = mobile;
        this.nationCode = nationCode;
    }

    public String getMobile() {
        return mobile;
    }

    public String getNationCode() {
        return nationCode;
    }

    public static TelBuilder builder() {
        return new TelBuilder();
    }

    public static class TelBuilder {

        private String mobile;
        private String nationCode;

        private TelBuilder() {
        }

        public TelBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public TelBuilder nationCode(String nationCode) {
            this.nationCode = nationCode;
            return this;
        }

        public Tel build() {
            return new Tel(mobile, nationCode);
        }
    }
}
