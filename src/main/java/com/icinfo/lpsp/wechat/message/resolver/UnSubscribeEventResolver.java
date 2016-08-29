package com.icinfo.lpsp.wechat.message.resolver;

import java.util.HashMap;

/**
 * 取消关注时间解析器
 * Created by yushunwei on 2016/8/14.
 */
public class UnSubscribeEventResolver extends BaseResolver implements IResolver {
    /**
     * 取消关注事件回复，回复空文本
     *
     * @param message 需要处理的原始消息
     * @return
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, String> message) throws Exception {
        System.out.println("取消关注方账号:"+message.get("FromUserName"));
        return "";
    }
}
