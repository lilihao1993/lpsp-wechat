package com.icinfo.lpsp.wechat.message.resolver;

import com.icinfo.lpsp.wechat.common.utils.WechatDownloadUtil;
import com.icinfo.lpsp.wechat.token.TokenManager;

import java.util.HashMap;

/**
 * 描述：视频消息解析器
 */
public class VideoMessageResolver  extends BaseResolver implements IResolver{

    /**
     * 描述：视频消息处理
     * @param message 需要处理的原始消息
     * @return
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, String> message) throws Exception {
        getUserVoice(message.get("ThumbMediaId"),message.get("MediaId"));
        return null;
    }

    /**
     * 描述：获取用户发送来的视频传到本地
     * @param ThumbMediaId 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     * @param MediaId 	视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     * @throws Exception
     */
    public void getUserVoice(String ThumbMediaId,String MediaId)throws Exception{
        //缩略图
        WechatDownloadUtil.downloadMedia("D:tt.jpg", TokenManager.getToken().getAccess_token(),ThumbMediaId);
        //视频
        WechatDownloadUtil.downloadMedia("D:tt.mp4", TokenManager.getToken().getAccess_token(),MediaId);
    }
}
