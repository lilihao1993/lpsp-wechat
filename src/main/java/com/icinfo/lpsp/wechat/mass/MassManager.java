package com.icinfo.lpsp.wechat.mass;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.lpsp.wechat.mass.bean.MassNews;
import com.icinfo.lpsp.wechat.mass.bean.MassResult;
import com.icinfo.lpsp.wechat.mass.bean.TagMassNews;
import com.icinfo.lpsp.wechat.material.MaterialApi;
import com.icinfo.lpsp.wechat.material.model.Articles;
import com.icinfo.lpsp.wechat.material.model.News;
import com.icinfo.lpsp.wechat.token.TokenManager;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：群发素材管理器
 */
public class MassManager {

    public static void main(String[] args) throws Exception {
        String token = TokenManager.getToken().getAccess_token();
        //appid群发图文
        massNews(token);
        //tag群发图文
//        tagMassNews(token);
    }

    /**
     * 描述：appid群发图文
     * @throws Exception
     */
    public static void massNews(String token)throws Exception{
        //创建图文
        News  news = new News();
        news.setThumb_media_id("jUJtGNTzPnU7oRkacNKcHxnYoIl2FlO8DeCaWGQHxI8");
        news.setContent("大火信息");
        news.setDigest("图文描述");
        news.setAuthor("LLH");
        news.setTitle("title");
        news.setContent_source_url("www.qq.com");
        news.setShow_cover_pic("0");
        List<News> list = new ArrayList();
        list.add(news);
        Articles articles = new Articles();
        articles.setArticles(list);
        String messageID = MaterialApi.addForeverNewsMaterial(token,articles);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,String> map = objectMapper.readValue(messageID, Map.class);
        System.out.println(messageID);

        MassNews massNews = new MassNews();
        Map<String,String> map1 = new HashMap();
        map1.put("media_id",map.get("media_id"));

        massNews.setMpnews(map1);
        massNews.setMsgtype("mpnews");
        List<String> list1 = new ArrayList();
        list1.add("ohwKTwqOlrW1Z44-MLWPAWfuPlRw");
        list1.add("ohwKTwrlvXLucUTWDQ6uD7OJCIeE");
        massNews.setTouser(list1);
        System.out.println(massNews.toString());
        MassResult massResult= MassAPI.massNews(token,massNews);
        System.out.println(massResult.toString()+":"+massResult.getErrcode()+":"+massResult.getErrmsg());
    }


    /**
     * 描述：上传图文消息素材
     * @param token
     * @return
     * @throws Exception
     */
    public static String uploadNews(String token)throws Exception{
        //创建图文
        News  news = new News();
        news.setThumb_media_id("jUJtGNTzPnU7oRkacNKcHxnYoIl2FlO8DeCaWGQHxI8");
        news.setContent("大火信息");
        news.setDigest("图文描述");
        news.setAuthor("LLH");
        news.setTitle("title");
        news.setContent_source_url("www.qq.com");
        news.setShow_cover_pic("0");
        List<News> list = new ArrayList();
        list.add(news);
        Articles articles = new Articles();
        articles.setArticles(list);
        String messageID = MaterialApi.addForeverNewsMaterial(token,articles);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,String> map = objectMapper.readValue(messageID, Map.class);
        System.out.println("////////////////////:"+messageID);
        return map.get("media_id");
    }
    /**
     * 描述：标签群发图文
     * @throws Exception
     */
    public static void tagMassNews(String token)throws Exception{
        TagMassNews tagMassNews = new TagMassNews();
        Map<String,String> map = new HashMap();
        map.put("is_to_all","false");
        map.put("tag_id","104");
        Map<String,String> map1 = new HashMap();
        map1.put("media_id",uploadNews(token));
        tagMassNews.setFilter(map);
        tagMassNews.setMpnews(map1);
        tagMassNews.setMsgtype("mpnews");
        MassResult massResult = MassAPI.tagMassNews(token,tagMassNews);
        if ("0".equals(massResult.getErrcode())){
            System.out.println("发送成功");
            System.out.println(massResult.getMsg_data_id()+":"+massResult.getMsg_id());
        }else{
            System.out.println("发送失败:"+massResult.getErrcode());
        }
    }

}
