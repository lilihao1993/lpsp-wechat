package com.icinfo.lpsp.wechat;

import com.icinfo.lpsp.wechat.base.BaseAPI;
import com.icinfo.lpsp.wechat.base.BaseResult;
import com.icinfo.lpsp.wechat.client.HttpClientExecutor;
import com.icinfo.lpsp.wechat.common.utils.JSONUtils;
import com.icinfo.lpsp.wechat.token.TokenManager;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 获取公众号的自动回复规则
 */
public class Test2 extends BaseAPI{
    public static void main(String[] args) throws Exception{
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/get_current_autoreply_info")
                .addParameter(PARAM_ACCESS_TOKEN, TokenManager.getToken().getAccess_token())
                .build();
        System.out.println(HttpClientExecutor.executeJsonResult(httpUriRequest, String.class));
    }
}
