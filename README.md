# qcloud-sms-spring-boot-starter
基于 `Spring Boot` 框架，快速集成【腾讯云】【短信】服务

## 快速集成
1. 在 `pom.xml` 文件中引入依赖
    ```xml
    <dependency>
        <groupId>com.github.zhangquanli</groupId>
        <artifactId>qcloud-sms-spring-boot-starter</artifactId>
        <version>1.0.2</version>
    </dependency>
    ```
2. 在 `application.properties` 或 `application.yml` 文件中，进行配置
    ```properties
    qcloud.sms.app-id=appId
    qcloud.sms.app-key=appKey
    ```
    ```yaml
    qcloud:
      sms:
        app-id: appId
        app-key: appKey
    ```

## 快速开发
1. 在 `Spring Boot` 项目中，可以直接注入 `QcloudSms` 接口
    ```java
    @Resource
    private QcloudSms qcloudSms;
    ```
2. 使用 `QcloudSms` 接口中的方法

## 更新日志
### 1.0.2
1. 重构代码实现，优化请求构造
### 1.0.1
1. 增加日志记录
### 1.0.0
1. 封装【腾讯云】【短信】服务相关接口