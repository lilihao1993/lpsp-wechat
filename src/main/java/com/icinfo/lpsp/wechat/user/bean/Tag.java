package com.icinfo.lpsp.wechat.user.bean;

import com.icinfo.lpsp.wechat.base.BaseResult;

/**
 * 描述:标签
 */
public class Tag extends BaseResult{
    /**
     * 标签id
     */
    private String id;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 此标签下的用户数量
     */
    private String count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
