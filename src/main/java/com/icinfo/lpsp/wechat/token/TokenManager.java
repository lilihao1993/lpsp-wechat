package com.icinfo.lpsp.wechat.token;

import com.icinfo.lpsp.wechat.common.utils.ConfigUtils;

/**
 * access_token 中控服务器
 * Created by yushunwei on 2016/8/14.
 */
public class TokenManager {

    // access_token
    private static Token token;

    /**
     * 获取access_token
     *
     * @return 返回access_token
     * @throws Exception
     */
    public static Token getToken() throws Exception {
        // 如果access_token 为空，则直接获取后返回
        if (token == null) {
            refreshToken();
            return token;
        }

        // 如果access_token已经失效，则刷新access_token
        if (System.currentTimeMillis() >= token.getExpires_in()) {
            refreshToken();
        }

        return token;
    }

    /**
     * 刷新access_token
     *
     * @throws Exception
     */
    public static void refreshToken() throws Exception {
        token = TokenAPI.getToken(ConfigUtils.getConfig("config.appID"), ConfigUtils.getConfig("config.appsecret"));
        // 直接计算超时时间并存储，提前100秒
        token.setExpires_in(System.currentTimeMillis() + 7100 * 1000);
    }
}