package com.icinfo.lpsp.wechat.mass.bean;

import java.util.Map;

/**
 * 描述：标签群发图文model
 */
public class TagMassNews  {
    private Map<String,String> filter;
    private Map<String,String> mpnews;
    private String msgtype;

    public Map<String, String> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, String> filter) {
        this.filter = filter;
    }

    public Map<String, String> getMpnews() {
        return mpnews;
    }

    public void setMpnews(Map<String, String> mpnews) {
        this.mpnews = mpnews;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
