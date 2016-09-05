package com.icinfo.lpsp.wechat.mass.bean;

import com.icinfo.lpsp.wechat.base.BaseResult;

/**
 * 描述：群发返回信息
 */
public class MassResult extends BaseResult{
    /**
     * 消息发送任务的ID
     */
    private String msg_id;
    /**
     * 消息的数据ID，，该字段只有在群发图文消息时，才会出现。
     * 可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
     * 是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
     */
    private String msg_data_id;

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(String msg_data_id) {
        this.msg_data_id = msg_data_id;
    }

    @Override
    public String toString() {
        return "MassResult{" +
                "msg_id='" + msg_id + '\'' +
                ", msg_data_id='" + msg_data_id + '\'' +
                '}';
    }
}
