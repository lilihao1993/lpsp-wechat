package com.icinfo.lpsp.wechat.message;

import com.icinfo.lpsp.wechat.message.resolver.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息路由处理
 * Created by yushunwei on 2016/8/14.
 */
public class MessageRouter {

    // 消息解析器集合初始化
    private static Map<String, Class> resolvers = new HashMap<String, Class>() {{
        // 文本消息
        put("text", TextMessageResolver.class);
        //语音消息
        put("voice",VoiceMessageResolver.class);
        //视频
        put("video",VideoMessageResolver.class);
        //小视频消息
        put("shortvideo",VideoMessageResolver.class);
        // 关注事件
        put("eventsubscribe", SubscribeEventResolver.class);
        // 取消关注事件
        put("eventunsubscribe", UnSubscribeEventResolver.class);
        //测试点击事件
        put("eventCLICK", ClickEventResolver.class);
        //获取地理位置
        put("eventLOCATION", LocationEventResolver.class);


    }};

    /**
     * 消息路由
     *
     * @param message 消息
     * @return 路由结果
     * @throws Exception
     */
    public static String route(Map<String, String> message) throws Exception {
        // 获取msgType 和 event 组合作为路由标识
        String msgType = message.get("MsgType");
        String event = message.get("Event");

        // 动态获取路由目标类
        Class clazz = resolvers.get((msgType + event).replace("null", ""));
        // 如果对应解析器还未实现，则返回空文本，微信服务器不会对此作任何处理，并且不会发起重试
        if (clazz == null) {
            return "";
        }
        // 反射调用解析方法并返回结果
        Method m = clazz.getDeclaredMethod("resolve", new Class[]{HashMap.class});
        if (m == null) {
            return "";
        }
        return (String) m.invoke(clazz.newInstance(), message);
    }

}
