package com.icinfo.lpsp.wechat.mass.bean;

import java.util.List;
import java.util.Map;

/**
 * 描述：群发图文model
 */
public class MassNews {
    /**
     * openid 列表
     */
    private List<String> touser;
    /**
     * media_id 图文id
     */
    private Map<String,String> mpnews;
    /**
     * mpnews图文类型
     */
    private String msgtype;

    public List<String> getTouser() {
        return touser;
    }

    public void setTouser(List<String> touser) {
        this.touser = touser;
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
