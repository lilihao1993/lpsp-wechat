package com.icinfo.lpsp.wechat.message.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 播放地址
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicBitrate {
    //具体播放地址
    private String file_link;

    public String getFile_link() {
        return file_link;
    }

    public void setFile_link(String file_link) {
        this.file_link = file_link;
    }
}
