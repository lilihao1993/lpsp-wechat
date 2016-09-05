package com.icinfo.lpsp.wechat.mass.bean;

import java.util.List;

/**
 * 描述：群发文本model
 */
public class MassText {
    /**
     *oppenid
     */
    private List<String> touser;
    /**
     * 类型
     */
    private String msgtype;
    /**
     * 文本
     */
    private String text;

    public List<String> getTouser() {
        return touser;
    }

    public void setTouser(List<String> touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
