package com.icinfo.lpsp.wechat.message.bean;

import com.icinfo.lpsp.wechat.base.BaseMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 响应文本消息
 * Created by yushunwei on 2016/8/14.
 */
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
