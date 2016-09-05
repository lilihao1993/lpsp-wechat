package com.icinfo.lpsp.wechat.user.bean;

import com.icinfo.lpsp.wechat.base.BaseResult;


/**
 * 描述：结果集
 */
public class TagListResult extends BaseResult {
    private Tag[] tags;

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }
}
