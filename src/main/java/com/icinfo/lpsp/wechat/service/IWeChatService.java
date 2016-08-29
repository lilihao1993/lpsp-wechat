package com.icinfo.lpsp.wechat.service;

import com.icinfo.lpsp.wechat.jssign.JSSign;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信服务接口
 * Created by yushunwei on 2016/8/13.
 */
public interface IWeChatService {
    /**
     * 微信消息处理
     * @param request 微信请求
     * @return 消息响应
     * @throws Exception
     */
    String message(HttpServletRequest request) throws Exception;

    /**
     * 获取js-sdk调用签名对象
     * @param url 客户端url
     * @return 前面对象
     * @throws Exception
     */
    JSSign jsSign(final String url) throws Exception;
}
