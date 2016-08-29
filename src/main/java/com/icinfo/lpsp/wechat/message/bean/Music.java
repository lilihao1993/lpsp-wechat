package com.icinfo.lpsp.wechat.message.bean;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Music {
    /**
     * 标题
     */
    private String Title;

    /**
     * 描述
     */
    private String Description;

    /**
     *音乐链接
     */
    private String MusicUrl;
    /**
     * 高质量音乐链接
     */
    private String HQMusicUrl;

    /**
     * 缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
     *
     */
    private String ThumbMediaId;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMusicUrl() {
        return MusicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        MusicUrl = musicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
