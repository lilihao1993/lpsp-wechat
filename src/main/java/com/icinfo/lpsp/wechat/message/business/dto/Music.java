package com.icinfo.lpsp.wechat.message.business.dto;

import java.util.List;

/**
 * 描述：音乐
 */
public class Music {
    /**
     * 歌曲列表
     */
    private List<MusicSong> song_list;

    /**
     * 广告
     */
    private MusicBillboard billboard;

    /**
     * 状态码
     */
    private String error_code;

    public List<MusicSong> getSong_list() {
        return song_list;
    }

    public void setSong_list(List<MusicSong> song_list) {
        this.song_list = song_list;
    }

    public MusicBillboard getBillboard() {
        return billboard;
    }

    public void setBillboard(MusicBillboard billboard) {
        this.billboard = billboard;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}
