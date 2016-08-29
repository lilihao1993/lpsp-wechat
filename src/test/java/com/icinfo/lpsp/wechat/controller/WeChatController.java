package com.icinfo.lpsp.wechat.controller;


import com.icinfo.lpsp.wechat.common.utils.DigestUtils;
import com.icinfo.lpsp.wechat.common.config.SysConfig;
import com.icinfo.lpsp.wechat.jssign.JSSign;
import com.icinfo.lpsp.wechat.service.IWeChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 微信相关请求控制器
 * Created by yushunwei on 2016/8/7.
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {

    private static final Logger logger = LoggerFactory.getLogger(WeChatController.class);

    // 系统配置
    @Autowired
    private SysConfig sysConfig;

    @Autowired
    private IWeChatService weChatService;

    /**
     * 开发者接入认证服务
     * @param request 微信请求
     * @return 认证结果
     * @throws Exception
     */
    @RequestMapping(value="/service",method = RequestMethod.GET)
    @ResponseBody
    public String devJoin(HttpServletRequest request) throws Exception{
        // 判断请求是否来源于微信
        if(isWeChatCall(request)){
            // 返回微信端随机字符串
            System.out.println(request.getParameter("echostr"));
            return  request.getParameter("echostr");
        }else{
            return "接入失败";
        }
    }

    /**
     * 微信消息处理
     * @param request 微信请求
     * @return 消息响应
     * @throws Exception
     */
    @RequestMapping(value="/service",method = RequestMethod.POST)
    @ResponseBody
    public String message(HttpServletRequest request) throws Exception{
        // 验证失败，直接回复空串，微信服务器不会对此作任何处理，并且不会发起重试
        if(!isWeChatCall(request)){
            return "";
        }
        String result = weChatService.message(request);
        return result;
    }

    /**
     * 获取js-sdk调用签名对象
     * @param url 客户端url
     * @return 签名对象
     * @throws Exception
     */
    public JSSign jsSign(@RequestParam(name = "url",required = true)String url) throws Exception{
        return weChatService.jsSign(url);
    }

    /**
     * 判断请求是否来源于微信
     * @param request 微信请求
     * @return Boolean.TRUE表示请求来源于微信
     * @throws Exception
     */
    private boolean isWeChatCall(HttpServletRequest request) throws Exception{
        // 获取签名值
        String signature = request.getParameter("signature");
        // 获取时间戳
        String timestamp = request.getParameter("timestamp");
        // 获取随机数
        String nonce = request.getParameter("nonce");
        // 组装Hash参数
        String[] digestP = {sysConfig.getToken(),timestamp,nonce};
        Arrays.sort(digestP);
        // 微信请求验证
        return DigestUtils.generate(digestP).equalsIgnoreCase(signature);
    }
}
