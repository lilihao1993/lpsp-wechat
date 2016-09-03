package com.icinfo.lpsp.wechat.QRcode;

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
 * 描述：生成带参数二维码
 */
public class QRCodeAPI  extends BaseAPI {


    /**
     * 描述：生成临时二维码
     * @param access_token    token
     * @param expire_seconds  二维码有效时间
     * @param action_name  二维码类型 QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param scene_id  场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @return
     */
    public static Map<String,String> createInterimCode(String access_token,String expire_seconds,String action_name,String scene_id) throws Exception {
        Map<String,Object> map = new HashMap();
        Map<String,Object> subMap = new HashMap();
        Map<String,String> scene = new HashMap();
        subMap.put("scene",scene);
        scene.put("scene_id",scene_id);
        map.put("expire_seconds",expire_seconds);
        map.put("action_name",action_name);
        map.put("action_info",subMap);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/qrcode/create")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest,Map.class);
    }
}
