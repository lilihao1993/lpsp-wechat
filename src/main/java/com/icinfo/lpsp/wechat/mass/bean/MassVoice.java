package com.icinfo.lpsp.wechat.mass.bean;

import java.util.List;
import java.util.Map;

/**
 * 描述：群发语音model
 */
public class MassVoice {

    /**
     * oppid : 此用户必须大于2
     */
    private List<String> touser;
    /**
     * media_id
     */
    private Map<String,String> voice;
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

    public Map<String, String> getVoice() {
        return voice;
    }

    public void setVoice(Map<String, String> voice) {
        this.voice = voice;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
