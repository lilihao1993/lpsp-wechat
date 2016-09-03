package com.icinfo.lpsp.wechat.message.resolver;

import com.icinfo.lpsp.wechat.common.utils.XMLUtils;
import com.icinfo.lpsp.wechat.message.bean.TextMessage;

import java.util.HashMap;

/**
 * 关注事件解析器
 * Created by yushunwei on 2016/8/14.
 */
public class SubscribeEventResolver extends BaseResolver implements IResolver {

    /**
     * 关注事件回复，回复文本消息
     *
     * @param message 需要处理的原始事件
     * @return 回复的文本消息
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, String> message) throws Exception {
        TextMessage respMessage = new TextMessage();
        setBaseMessage(respMessage, message);
        respMessage.setMsgType(MESSAGE_TEXT);
        //如果EventKey不为空则表示为带参数二维码关注事件
        if (message.get("EventKey") != null){
            parameter();
            respMessage.setContent("您扫描的是带参数的二维码");
            return XMLUtils.parseXml(respMessage);
        }

        respMessage.setContent("当前为测试服务号，仅供测试人员使用，感谢您的关注！");
        return XMLUtils.parseXml(respMessage);
    }

    /**
     * 描述：处理二维码关注事件
     * @return
     * @throws Exception
     */
    public String parameter()throws Exception{
        return null;
    }
}
