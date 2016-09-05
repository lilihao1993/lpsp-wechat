package com.icinfo.lpsp.wechat.user.bean;

import com.icinfo.lpsp.wechat.base.BaseResult;

import java.util.List;

/**
 * 描述：用户标签列表
 */
public class UserTagList extends BaseResult{
    private List<String> tagid_list;

    public List<String> getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(List<String> tagid_list) {
        this.tagid_list = tagid_list;
    }
}
