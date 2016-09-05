package com.icinfo.lpsp.wechat.mass;

import com.icinfo.lpsp.wechat.base.BaseAPI;
import com.icinfo.lpsp.wechat.client.HttpClientExecutor;
import com.icinfo.lpsp.wechat.common.utils.JSONUtils;
import com.icinfo.lpsp.wechat.common.utils.WechatUploadUtil;
import com.icinfo.lpsp.wechat.mass.bean.MassNews;
import com.icinfo.lpsp.wechat.mass.bean.MassResult;
import com.icinfo.lpsp.wechat.mass.bean.TagMassNews;
import com.icinfo.lpsp.wechat.material.model.Articles;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * 描述：群发API
 */
public class MassAPI extends BaseAPI {


    /**
     * 上传图片
     *
     * @param access_token token
     * @param url          图片连接
     * @return
     * @throws Exception
     */
    public static String uploadImg(String access_token, String url) throws Exception {
        String id = WechatUploadUtil.upload(access_token, url, "image");
        System.out.println("*************************："+id);
        return id;
    }

    /**
     * 描述：上传图文消息素材 返回media_id
     *
     * @param access_token token
     * @param articles     图文
     * @return 返回media_id
     * @throws Exception
     */
    public static String uploadNews(String access_token, Articles articles) throws Exception {
        System.out.println(JSONUtils.toJSONString(articles));
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/media/uploadnews")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(articles), Charset.forName("utf-8")))
                .build();
        Map<String, String> map = HttpClientExecutor.executeJsonResult(httpUriRequest, Map.class);
        return map.get("media_id");
    }

    /**
     * 描述：appid群发图文
     * @param access_token token
     * @param massNews appid群发图文model
     * @return
     * @throws Exception
     */
    public static MassResult massNews(String access_token, MassNews massNews) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/message/mass/send")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(massNews), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, MassResult.class);
    }


    /**
     * 描述：tag群发图文
     * @param access_token token
     * @param tagMassNews  tag群发图文model
     * @return
     * @throws Exception
     */
    public static MassResult tagMassNews(String access_token , TagMassNews tagMassNews)throws Exception{
        System.out.println(JSONUtils.toJSONString(tagMassNews));
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/message/mass/sendall")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(tagMassNews), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, MassResult.class);
    }
}
