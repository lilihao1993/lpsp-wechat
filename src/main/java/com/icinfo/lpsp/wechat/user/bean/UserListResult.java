package com.icinfo.lpsp.wechat.user.bean;

import com.icinfo.lpsp.wechat.base.BaseResult;

import java.util.List;
import java.util.Map;

/**
 * 标签下用户列表结果集
 */
public class UserListResult extends BaseResult {

    /**
     * 获取用户数量
     */
    private String count;
    /**
     * 用户列表
     * map唯一参数：openid
     */
    private Map<String,List<String>> data;
    /**
     * 拉取列表最后一个用户的openid
     */
    private String next_openid;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Map<String, List<String>> getData() {
        return data;
    }

    public void setData(Map<String, List<String>> data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}
