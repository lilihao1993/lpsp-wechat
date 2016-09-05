package com.icinfo.lpsp.wechat.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 描述：上传图片
 */
public class WechatUploadUtil {

    /**
     * 上传图片并获取url
     * @param tokenString token
     * @param url   图片路径
     * @param type  上传类型
     * @return
     * @throws IOException
     */
    public static String upload(String tokenString,String url,String type) throws IOException {
        WritableResource resource = new FileSystemResource(new File(url));
        MultiValueMap<String, Object> data = new LinkedMultiValueMap<String,Object>();
        data.add("media", resource);
        String urlString = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token="+tokenString+"&type="+type;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(urlString, data, String.class);
        System.out.println(result);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,String> map = objectMapper.readValue(result,Map.class);
        return map.get("url");
    }


    /**
     * 上传其他素材
     * @param tokenString token
     * @param url   图片路径
     * @param type  上传类型
     * @return
     * @throws IOException
     */
    public static String upload1(String tokenString,String url,String type) throws IOException {
        WritableResource resource = new FileSystemResource(new File(url));
        MultiValueMap<String, Object> data = new LinkedMultiValueMap<String,Object>();
        data.add("media", resource);
        String urlString = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="+tokenString+"&type="+type;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(urlString, data, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(result);
        Map<String,String> map = objectMapper.readValue(result,Map.class);
        return map.get("url");
    }
}
