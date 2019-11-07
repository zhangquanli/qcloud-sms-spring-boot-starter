package com.github.zhangquanli.qcloud.sms;

import com.github.zhangquanli.qcloud.sms.http.AbstractHttpClient;
import com.github.zhangquanli.qcloud.sms.request.*;
import com.github.zhangquanli.qcloud.sms.response.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.zhangquanli.qcloud.sms.constants.QcloudSmsConstants.*;

/**
 * QcloudSmsImpl
 *
 * @author zhangquanli
 */
public class QcloudSmsImpl extends AbstractHttpClient implements QcloudSms {

    public QcloudSmsImpl(QcloudSmsProperties qcloudSmsProperties) {
        super(qcloudSmsProperties);
    }

    @Override
    public SendSingleSmsResponse sendSingleSms(SendSingleSmsRequest sendSingleSmsRequest) {
        String mobile = sendSingleSmsRequest.getTel().getMobile();
        String responseJson = postParamsJson(SEND_SINGLE_SMS_URL, sendSingleSmsRequest, mobile);
        return convert(responseJson, SendSingleSmsResponse.class);
    }

    @Override
    public SendMultiSmsResponse sendMultiSms(SendMultiSmsRequest sendMultiSmsRequest) {
        List<String> mobiles = sendMultiSmsRequest.getTels().stream()
                .map(Tel::getMobile).collect(Collectors.toList());
        String responseJson = postParamsJson(SEND_MULTI_SMS_URL, sendMultiSmsRequest, mobiles);
        return convert(responseJson, SendMultiSmsResponse.class);
    }

    @Override
    public PullSendStatusResponse pullSendStatus(PullSendStatusRequest pullSendStatusRequest) {
        String responseJson = postParamsJson(PULL_SEND_STATUS_URL, pullSendStatusRequest);
        return convert(responseJson, PullSendStatusResponse.class);
    }

    @Override
    public PullCallbackStatusResponse pullCallbackStatus(PullCallbackStatusRequest pullCallbackStatusRequest) {
        String responseJson = postParamsJson(PULL_CALLBACK_STATUS_URL, pullCallbackStatusRequest);
        return convert(responseJson, PullCallbackStatusResponse.class);
    }

    @Override
    public GetSmsPackagesResponse getSmsPackages(GetSmsPackagesRequest getSmsPackagesRequest) {
        String responseJson = postParamsJson(GET_SMS_PACKAGES_URL, getSmsPackagesRequest);
        return convert(responseJson, GetSmsPackagesResponse.class);
    }
}
