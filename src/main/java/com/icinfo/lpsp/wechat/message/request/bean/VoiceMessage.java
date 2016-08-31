package com.icinfo.lpsp.wechat.message.request.bean;

import com.icinfo.lpsp.wechat.base.BaseMessage;

/**
 * 描述：接收用户语音消息基础类
 */
public class VoiceMessage extends BaseMessage{

    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据
     */
    private String MediaId;
    /**
     * 语音格式，如amr，speex等
     */
    private String Format;
    /**
     * 消息id，64位整型
     */
    private String MsgID;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    @Override
    public String toString() {
        return "VoiceMessage{" +
                "MediaId='" + MediaId + '\'' +
                ", Format='" + Format + '\'' +
                ", MsgID='" + MsgID + '\'' +
                '}';
    }
}
