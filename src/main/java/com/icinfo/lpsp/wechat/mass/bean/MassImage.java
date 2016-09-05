package com.icinfo.lpsp.wechat.mass.bean;

import java.util.List;
import java.util.Map;

/**
 * 描述：群发图片model
 */
public class MassImage {
    /**
     * 用户oppid
     */
    private List<String> touser;
    /**
     * media_id
     */
    private Map<String,String> image;
    /**
     * 类型
     */
    private String msgtype;

    public List<String> getTouser() {
        return touser;
    }

    public void setTouser(List<String> touser) {
        this.touser = touser;
    }

    public Map<String, String> getImage() {
        return image;
    }

    public void setImage(Map<String, String> image) {
        this.image = image;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
