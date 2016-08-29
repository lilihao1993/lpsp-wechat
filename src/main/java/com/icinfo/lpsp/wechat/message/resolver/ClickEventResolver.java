package com.icinfo.lpsp.wechat.message.resolver;

import com.icinfo.lpsp.wechat.common.utils.XMLUtils;
import com.icinfo.lpsp.wechat.message.bean.Article;
import com.icinfo.lpsp.wechat.message.bean.NewsMessage;
import com.icinfo.lpsp.wechat.message.bean.TextMessage;
import com.icinfo.lpsp.wechat.message.business.Api;
import com.icinfo.lpsp.wechat.message.business.StringUtil;
import com.icinfo.lpsp.wechat.message.business.TextService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:点击事件
 */
public class ClickEventResolver extends BaseResolver implements IResolver {

    @Override
    public String resolve(HashMap<String, String> message) throws Exception {

        /**
         * 判断回复文本还是图文信息
         */
        if ("ArticleMessage".equals(message.get("EventKey"))) {
            return responseArticleMessage(message);
        } else {
            return responseTestMessage(message);
        }
    }

    /**
     * 描述：点击事件回复图文信息
     *
     * @return
     */
    public String responseArticleMessage(HashMap<String, String> message) throws Exception {
        NewsMessage newsMessage = new NewsMessage();
        Article article = new Article();
        List<Article> list = new ArrayList<>();
        setBaseMessage(newsMessage,message);
        newsMessage.setArticleCount(1);
        newsMessage.setMsgType(MESSAGE_Article);
        StringUtil.NewsIntegration(Api.getTopNews(),article);
        list.add(article);
        newsMessage.setArticles(list);
        String str = XMLUtils.parseXml(newsMessage);
        System.out.println(str);
        return str;
    }

    /**
     * 描述：点击回复文本信息
     *
     * @return
     */
    public String responseTestMessage(HashMap<String, String> message) throws Exception {
        TextMessage respMessage = new TextMessage();
        setBaseMessage(respMessage, message);
        respMessage.setMsgType(MESSAGE_TEXT);
        respMessage.setContent(TextService.responseClick(message.get("EventKey")));
        String str = XMLUtils.parseXml(respMessage);
        System.out.println(str);
        return str;
    }
}
