package com.icinfo.lpsp.wechat.message.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 描述：获取播放地址
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicAd {
    //获取播放地址
    private MusicBitrate bitrate;

    public MusicBitrate getBitrate() {
        return bitrate;
    }

    public void setBitrate(MusicBitrate bitrate) {
        this.bitrate = bitrate;
    }
}
