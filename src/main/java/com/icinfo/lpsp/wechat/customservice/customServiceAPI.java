package com.icinfo.lpsp.wechat.customservice;

import com.icinfo.lpsp.wechat.base.BaseAPI;
import com.icinfo.lpsp.wechat.client.HttpClientExecutor;
import com.icinfo.lpsp.wechat.common.utils.JSONUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：客服API
 */
public class CustomServiceAPI extends BaseAPI {


    /**
     * 描述:增加客服账号
     * @param kf_account 客服账号
     * @param nickname   昵称
     * @param password  密码
     * @throws Exception
     */
    public static void customServiceAdd(String access_token,String kf_account,String nickname,String password)throws Exception{
        Map<String,String> map = new HashMap();
        map.put("kf_account",kf_account);
        map.put("nickname",nickname);
        map.put("password",password);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/customservice/kfaccount/add")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        Map<String,Object> requestMap = HttpClientExecutor.executeJsonResult(httpUriRequest,Map.class);
        System.out.println(requestMap.get("errcode")+":------"+requestMap.get("errmsg"));
    }
}
