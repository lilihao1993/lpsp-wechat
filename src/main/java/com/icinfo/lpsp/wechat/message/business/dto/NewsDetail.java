package com.icinfo.lpsp.wechat.message.business.dto;

/**
 * 描述：新闻详情
 */
public class NewsDetail {
    /**
     * 标题
     */
    private String title;
    /**
     * 日期
     */
    private String date;
    /**
     * 作者名称
     */
    private String author_name;
    /**
     * 缩略图图片1
     */
    private String thumbnail_pic_s;
    /**
     * 缩略图片2
     */
    private String thumbnail_pic_s02;
    /**
     * 缩略图片3
     */
    private String thumbnail_pic_s03;
    /**
     * 地址
     */
    private String url;
    /**
     * 唯一约束
     */
    private String uniquekey;
    /**
     * 类型
     */
    private String  type;

    public String getRealtype() {
        return realtype;
    }

    public void setRealtype(String realtype) {
        this.realtype = realtype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 新闻类型

     */
    private String realtype;
}
