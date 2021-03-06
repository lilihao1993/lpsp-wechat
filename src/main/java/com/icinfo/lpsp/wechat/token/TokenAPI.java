package com.icinfo.lpsp.wechat.token;

import com.icinfo.lpsp.wechat.base.BaseAPI;
import com.icinfo.lpsp.wechat.client.HttpClientExecutor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * Access_token API
 * Created by yushunwei on 2016/8/7.
 */
public class TokenAPI extends BaseAPI {

    /**
     * 获取接口调用access_token
     *
     * @param appID     公众号ID
     * @param appsecret 公众号秘钥
     * @return 获取的access_token
     * @throws Exception
     */
    public static Token getToken(String appID, String appsecret) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/token")
                .addParameter("grant_type", "client_credential")
                .addParameter("appid", appID)
                .addParameter("secret", appsecret)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, Token.class);
    }
}
