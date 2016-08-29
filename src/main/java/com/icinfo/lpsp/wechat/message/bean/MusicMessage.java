package com.icinfo.lpsp.wechat.message.bean;

import com.icinfo.lpsp.wechat.base.BaseMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 描述：音乐api
 */
@XStreamAlias("xml")
public class MusicMessage extends BaseMessage {
    /**
     * 音乐
     */
    @XStreamAlias("Music")
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
