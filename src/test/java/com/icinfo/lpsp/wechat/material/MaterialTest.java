package com.icinfo.lpsp.wechat.material;

import com.icinfo.lpsp.wechat.material.model.Articles;
import com.icinfo.lpsp.wechat.material.model.News;
import com.icinfo.lpsp.wechat.message.bean.Article;
import com.icinfo.lpsp.wechat.message.business.Api;
import com.icinfo.lpsp.wechat.message.business.StringUtil;
import com.icinfo.lpsp.wechat.token.TokenManager;

import java.util.ArrayList;
import java.util.List;


/**
 * 描述：素材测试
 */
public class MaterialTest {

    public static void main(String[] args) throws Exception {
        List<News> newsList = new ArrayList<>();
        News news = new News();
        news.setTitle("测试111");
        news.setThumb_media_id("jUJtGNTzPnU7oRkacNKcH4GV3ESBXVap0Rrmwh17J20");
        news.setThumb_url("http://07.imgmini.eastday.com/mobile/20160905/20160905104233_ed7ac42432542c2b7aba81b8c4cbaa81_1_mwpl_05500201.jpeg");
        news.setAuthor("ysh");
        news.setDigest("测试作用");
        news.setShow_cover_pic("0");
        news.setContent("测试内容");
        news.setContent_source_url("http://mini.eastday.com/mobile/160905104233994.html?qid=juheshuju");
        newsList.add(news);
        Articles article = new Articles();
        article.setArticles(newsList);
        //添加素材
        System.out.println(MaterialManager.addForeverNewsMaterial(TokenManager.getToken().getAccess_token(), article));
    }
}
