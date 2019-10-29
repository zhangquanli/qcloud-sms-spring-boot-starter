package com.github.zhangquanli.qcloud.sms.constants;

/**
 * QcloudSmsConstants
 *
 * @author zhangquanli
 */
public interface QcloudSmsConstants {

    /**
     * 指定模板单发短信
     */
    String SEND_SINGLE_SMS_URL = "https://yun.tim.qq.com/v5/tlssmssvr/sendsms";
    /**
     * 指定模板群发短信
     */
    String SEND_MULTI_SMS_URL = "https://yun.tim.qq.com/v5/tlssmssvr/sendmultisms2";

    /**
     * 发送数据统计
     */
    String PULL_SEND_STATUS_URL = "https://yun.tim.qq.com/v5/tlssmssvr/pullsendstatus";
    /**
     * 回执数据统计
     */
    String PULL_CALLBACK_STATUS_URL = "https://yun.tim.qq.com/v5/tlssmssvr/pullcallbackstatus";
    /**
     * 查询短信套餐包信息
     */
    String GET_SMS_PACKAGES_URL = "https://yun.tim.qq.com/v5/tlssmssvr/getsmspackages";
}
