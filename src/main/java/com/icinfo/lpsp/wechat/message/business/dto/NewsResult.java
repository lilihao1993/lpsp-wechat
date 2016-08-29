package com.icinfo.lpsp.wechat.message.business.dto;

import java.util.List;

/**
 * 描述：新闻结果集
 */
public class NewsResult {
    private String stat;
    /**
     * 数据
     */
    private List<NewsDetail>data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<NewsDetail> getData() {
        return data;
    }

    public void setData(List<NewsDetail>data) {
        this.data = data;
    }
}
