package com.icinfo.lpsp.wechat.message.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.lpsp.wechat.message.business.dto.News;
import com.icinfo.lpsp.wechat.message.business.dto.NewsDetail;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * 描述：根据接口获取网络数据
 */
public class Api {

    /**
     * 描述：获取头条新闻
     */
    public static List<NewsDetail> getTopNews() throws IOException {
        URL url = new URL("http://v.juhe.cn/toutiao/index?type=today&key=0b48fea1a5cf85a12dcbc78605e10242");
        InputStream inputStream = url.openStream();
        ObjectMapper objectMapper = new ObjectMapper();
        News news = objectMapper.readValue(inputStream, News.class);
        if (news.getError_code() == 0) {
            return news.getResult().getData();
        } else {
            return null;
        }
    }
}
