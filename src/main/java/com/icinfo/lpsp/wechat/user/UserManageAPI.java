package com.icinfo.lpsp.wechat.user;

import com.icinfo.lpsp.wechat.base.BaseAPI;
import com.icinfo.lpsp.wechat.base.BaseResult;
import com.icinfo.lpsp.wechat.client.HttpClientExecutor;
import com.icinfo.lpsp.wechat.common.utils.JSONUtils;
import com.icinfo.lpsp.wechat.user.bean.*;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：用户管理API
 */
public class UserManageAPI extends BaseAPI {


    /**
     * 描述：创建标签
     *
     * @param name 名称
     * @return
     * @throws Exception
     */
    public static Tag creatTag(String access_token, String name) throws Exception {
        Map<String, Map<String, String>> map = new HashMap();
        Map<String, String> map1 = new HashMap();
        map1.put("name", name);
        map.put("tag", map1);
        System.out.println(JSONUtils.toJSONString(map));
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/tags/create")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        TagResult tagResult = HttpClientExecutor.executeJsonResult(httpUriRequest, TagResult.class);
        return tagResult.getTag();
    }


    /**
     * 描述：获取标签列表
     *
     * @param access_token token
     * @return
     * @throws Exception
     */
    public static Tag[] getTags(String access_token) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/tags/get")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        TagListResult resultMap = HttpClientExecutor.executeJsonResult(httpUriRequest, TagListResult.class);
        return  resultMap.getTags();
    }


    /**
     * 描述：修改标签
     * @param access_token token
     * @param id  标签id
     * @param name  标签名称
     * @return
     * @throws Exception
     */
    public static Tag modifyTag(String access_token, String id, String name) throws Exception {
        Map<String,Map<String,String>> map = new HashMap();
        Map<String,String> map1 = new HashMap();
        map1.put("id",id);
        map1.put("name",name);
        map.put("tag",map1);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/tags/update")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
         return  HttpClientExecutor.executeJsonResult(httpUriRequest, Tag.class);
    }


    /**
     * 描述：删除标签
     * @param access_token token
     * @param id 标签id
     * @return
     * @throws Exception
     */
    public static Tag deleteTag(String access_token, String id)throws Exception{
        Map<String,Map<String,String>> map = new HashMap();
        Map<String,String> map1 = new HashMap();
        map1.put("id",id);
        map.put("tag",map1);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/tags/delete")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, Tag.class);
    }

    /**
     * 描述：获取标签下用户列表
     * @param access_token token
     * @param id  标签id
     * @param next_openid  第一个拉取的OPENID，不填默认从头开始拉取  可以为空
     * @return
     * @throws Exception
     */
    public static UserListResult getUserList(String access_token,String id,String next_openid)throws Exception{
        Map<String,Map<String,String>> map = new HashMap();
        Map<String,String> map1 = new HashMap();
        map1.put("tagid",id);
        map1.put("next_openid",next_openid);
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/user/tag/get")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, UserListResult.class);
    }


    /**
     * 描述：批量为用户打标签
     * @param access_token token
     * @param list  用户id列表
     * @param tagId  标签id
     * @return
     * @throws Exception
     */
    public static BaseResult batchTag(String access_token, List<String> list, String tagId)throws Exception{
        Map<String,Object> map = new HashMap();
        map.put("openid_list",list);
        map.put("tagid",tagId);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/tags/members/batchtagging")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 描述：批量为用户取消标签
     * @param access_token token
     * @param list 用户列表
     * @param tagid  标签id
     * @return
     * @throws Exception
     */
    public static BaseResult batchUntag(String access_token,List<String> list,String tagid)throws Exception{
        Map<String,Object> map = new HashMap();
        map.put("openid_list",list);
        map.put("tagid",tagid);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/tags/members/batchuntagging")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 描述： 获取用户身上的标签列表
     * @param access_token token
     * @param openid  用户id
     * @return
     * @throws Exception
     */
    public static UserTagList getUserTag(String access_token,String openid)throws Exception{
        Map<String,String> map = new HashMap();
        map.put("openid",openid);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/tags/getidlist")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return  HttpClientExecutor.executeJsonResult(httpUriRequest, UserTagList.class);
    }
}
