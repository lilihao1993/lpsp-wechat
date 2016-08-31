package com.icinfo.lpsp.wechat.message.resolver;

import com.icinfo.lpsp.wechat.base.BaseMessage;
import com.icinfo.lpsp.wechat.common.utils.WechatDownloadUtil;
import com.icinfo.lpsp.wechat.token.TokenManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：语音消息解析器
 */
public class VoiceMessageResolver extends BaseResolver implements IResolver{


    /**
     * 语音消息处理
     * @param message 需要处理的原始消息
     * @return
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, String> message) throws Exception {
        getUserVoice(message.get("Format"),message.get("Recognition"),message.get("MediaId"));
        return null;
    }

    /**
     * 描述：获取用户发送来的语音传到本地
     * @param Format 语音格式
     * @param Recognition 语音识别
     * @param MediaId  语音消息媒体id
     * @throws Exception
     */
    public void getUserVoice(String Format,String Recognition,String MediaId)throws Exception{
        System.out.println(Recognition);
        WechatDownloadUtil.downloadMedia("D:vli."+Format, TokenManager.getToken().getAccess_token(),MediaId);
    }


}
