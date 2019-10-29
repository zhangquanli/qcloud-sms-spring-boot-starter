package com.github.zhangquanli.qcloud.sms;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QcloudSmsAutoConfiguration
 *
 * @author zhangquanli
 */
@Configuration
@EnableConfigurationProperties(QcloudSmsProperties.class)
@ConditionalOnProperty(prefix = "qcloud.sms", name = {"app-id", "app-key"})
public class QcloudSmsAutoConfiguration {

    private QcloudSmsProperties qcloudSmsProperties;

    public QcloudSmsAutoConfiguration(QcloudSmsProperties qcloudSmsProperties) {
        this.qcloudSmsProperties = qcloudSmsProperties;
    }

    @Bean
    public QcloudSms qcloudSms() {
        return new QcloudSmsImpl(qcloudSmsProperties);
    }
}
