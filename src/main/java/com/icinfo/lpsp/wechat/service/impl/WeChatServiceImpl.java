package com.icinfo.lpsp.wechat.service.impl;

import com.icinfo.lpsp.wechat.common.config.SysConfig;
import com.icinfo.lpsp.wechat.common.utils.DigestUtils;
import com.icinfo.lpsp.wechat.common.utils.StringUtils;
import com.icinfo.lpsp.wechat.jssign.JSSign;
import com.icinfo.lpsp.wechat.common.utils.XMLUtils;
import com.icinfo.lpsp.wechat.message.MessageRouter;
import com.icinfo.lpsp.wechat.service.IWeChatService;
import com.icinfo.lpsp.wechat.ticket.TicketManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * 微信服务接口实现
 * Created by yushunwei on 2016/8/13.
 */
@Service
public class WeChatServiceImpl implements IWeChatService {

    // 系统配置
    @Autowired
    private SysConfig sysConfig;

    /**
     * 微信消息处理
     *
     * @param request 微信请求
     * @return 消息响应
     * @throws Exception
     */
    @Override
    public String message(HttpServletRequest request) throws Exception {
        // 获取消息信息
        Map<String, String> messageMap = XMLUtils.parseXml(request);
        return MessageRouter.route(messageMap);
    }

    /**
     * 获取js-sdk调用签名对象
     *
     * @param url 客户端url
     * @return 签名对象
     * @throws Exception
     */
    @Override
    public JSSign jsSign(String url) throws Exception {

        JSSign jsSign = new JSSign();
        // 设置公众号唯一标识
        jsSign.setAppId(sysConfig.getAppID());
        // 设置随机串
        jsSign.setNonceStr(UUID.randomUUID().toString());
        // 设置时间戳
        jsSign.setTimestamp(Long.toString(System.currentTimeMillis() / 1000));
        // 生成签名原文
        String signStr = StringUtils.assemblyString("jsapi_ticket=", TicketManager.getTicket().getTicket(),
                "&noncestr=", jsSign.getNonceStr(),
                "&timestamp=", jsSign.getTimestamp(),
                "&url=", url);
        // 设置签名值
        jsSign.setSignature(DigestUtils.generate(signStr));
        return jsSign;
    }
}
