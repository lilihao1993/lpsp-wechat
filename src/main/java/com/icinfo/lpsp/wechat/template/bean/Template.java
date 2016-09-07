package com.icinfo.lpsp.wechat.template.bean;

import com.icinfo.lpsp.wechat.base.BaseResult;

import java.util.Map;

/**
 * 描述：模版测试model
 */
public class Template extends BaseResult{
    /**
     * 接收者oppid
     */
    private String touser;
    /**
     * 模版id
     */
    private String template_id;
    /**
     * 点击连接地址
     */
    private String url;
    /**
     * 数据
     */
    private Templatel data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Templatel getData() {
        return data;
    }

    public void setData(Templatel data) {
        this.data = data;
    }
}
