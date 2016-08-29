package com.icinfo.lpsp.wechat.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yushunwei on 2016/8/7.
 */
@ConfigurationProperties(prefix = "config",locations = "classpath:sysConfig.properties")
public class SysConfig {

    /**
     * 公众号接入token
     */
    private String token;

    /**
     * 公众号凭证
     */
    private String appID;

    /**
     * 公众号凭证秘钥
     */
    private String appsecret;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }
}
