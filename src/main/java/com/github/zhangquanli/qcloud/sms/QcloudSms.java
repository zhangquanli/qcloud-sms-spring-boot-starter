package com.github.zhangquanli.qcloud.sms;

import com.github.zhangquanli.qcloud.sms.request.*;
import com.github.zhangquanli.qcloud.sms.response.*;

/**
 * QcloudSms
 *
 * @author zhangquanli
 */
public interface QcloudSms {

    /**
     * 指定模板单发短信
     *
     * @param sendSingleSmsRequest 请求参数
     * @return SendSingleSmsResponse
     */
    SendSingleSmsResponse sendSingleSms(SendSingleSmsRequest sendSingleSmsRequest);

    /**
     * 指定模板群发短信
     *
     * @param sendMultiSmsRequest 请求参数
     * @return SendMultiSmsResponse
     */
    SendMultiSmsResponse sendMultiSms(SendMultiSmsRequest sendMultiSmsRequest);

    /**
     * 发送数据统计
     *
     * @param pullSendStatusRequest 请求参数
     * @return PullSendStatusResponse
     */
    PullSendStatusResponse pullSendStatus(PullSendStatusRequest pullSendStatusRequest);

    /**
     * 回执数据统计
     *
     * @param pullCallbackStatusRequest 请求参数
     * @return PullCallbackStatusResponse
     */
    PullCallbackStatusResponse pullCallbackStatus(PullCallbackStatusRequest pullCallbackStatusRequest);

    /**
     * 查询短信套餐包信息
     *
     * @param getSmsPackagesRequest 请求参数
     * @return GetSmsPackagesResponse
     */
    GetSmsPackagesResponse getSmsPackages(GetSmsPackagesRequest getSmsPackagesRequest);
}
