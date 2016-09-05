package com.icinfo.lpsp.wechat.material;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.lpsp.wechat.base.BaseAPI;
import com.icinfo.lpsp.wechat.client.HttpClientExecutor;
import com.icinfo.lpsp.wechat.common.utils.JSONUtils;
import com.icinfo.lpsp.wechat.material.model.Articles;
import com.icinfo.lpsp.wechat.material.model.NewsMaterialList;
import com.icinfo.lpsp.wechat.material.model.NewsMaterials;
import com.icinfo.lpsp.wechat.material.model.OtherMaterialList;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：素材API
 *
 * @author zhangmengwen
 * @date 2016/8/26
 */
public class MaterialApi extends BaseAPI {

    /**
     * 描述：获取永久图文素材列表
     *
     * @param access_token token
     * @param map          参数：type，offset，count
     * @return 永久图文素材列表
     * @throws Exception
     */
    public static NewsMaterialList getForeverNewsMaterialsList(String access_token, Map<String, String> map) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/batchget_material")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();

        return HttpClientExecutor.executeJsonResult(httpUriRequest, NewsMaterialList.class);
    }

    /**
     * 描述：获取永久其他素材（图片、语音、视频）列表
     *
     * @param access_token token
     * @param map          参数：type，offset，count
     * @return 永久其他素材（图片、语音、视频）列表
     * @throws Exception
     */
    public static OtherMaterialList getForeverOtherMaterialsList(String access_token, Map<String, String> map) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/batchget_material")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, OtherMaterialList.class);


    }

    /**
     * 描述：获取永久图文素材
     *
     * @param media_id     素材id
     * @param access_token token
     * @return 永久图文素材
     * @throws Exception
     */
    public static NewsMaterials getForeverNewsMaterial(String media_id, String access_token) throws Exception {
        Map<String, String> map = new HashMap();
        map.put("media_id", media_id);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/get_material")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, NewsMaterials.class);
    }

    /**
     * 描述：新增永久图文素材
     *
     * @param articles     素材article结构列表
     * @param access_token token
     * @return 新增的素材id
     * @throws Exception
     */
    public static String addForeverNewsMaterial(String access_token, Articles articles) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/add_news")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(articles), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, String.class);
    }

    /**
     * 描述：获取素材总数
     *
     * @param access_token token
     * @return 素材总数
     * @throws Exception
     */
    public static Map<String, Object> getMaterialCount(String access_token) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/material/get_materialcount")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, Map.class);
    }

    /**
     * 上传其他素材
     * @param tokenString token
     * @param url   图片路径
     * @param type  上传类型
     * @return
     * @throws IOException
     */
    public static Map<String,String> upload(String tokenString,String url,String type) throws IOException {
        WritableResource resource = new FileSystemResource(new File(url));
        MultiValueMap<String, Object> data = new LinkedMultiValueMap<String,Object>();
        data.add("media", resource);
        String urlString = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="+tokenString+"&type="+type;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(urlString, data, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(result);
        return objectMapper.readValue(result,Map.class);

    }
}
