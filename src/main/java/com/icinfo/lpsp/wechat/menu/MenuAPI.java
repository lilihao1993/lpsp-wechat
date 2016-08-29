package com.icinfo.lpsp.wechat.menu;

import com.icinfo.lpsp.wechat.base.BaseAPI;
import com.icinfo.lpsp.wechat.base.BaseResult;
import com.icinfo.lpsp.wechat.client.HttpClientExecutor;
import com.icinfo.lpsp.wechat.common.utils.JSONUtils;
import com.icinfo.lpsp.wechat.menu.bean.Menu;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 菜单API
 * Created by yushunwei on 2016/8/14.
 */
public class MenuAPI extends BaseAPI {
    /**
     * 菜单创建
     * @param access_token 接口调用access_token
     * @param menu 菜单数据
     * @return 接口调用结果
     * @throws Exception
     */
    public static BaseResult menuCreate(String access_token,Menu menu) throws Exception{
        System.out.println(JSONUtils.toJSONString(menu));
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/menu/create")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(menu), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest,BaseResult.class);
    }
}
