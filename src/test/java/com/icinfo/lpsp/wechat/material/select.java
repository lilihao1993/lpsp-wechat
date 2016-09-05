package com.icinfo.lpsp.wechat.material;

import com.icinfo.lpsp.wechat.common.config.SysConfig;
import com.icinfo.lpsp.wechat.token.TokenManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：查询列表
 */
public class select {
    public static void main(String[] args) {
        Map<String, Object> materialCount = new HashMap<>();
        try {
            String access_token = TokenManager.getToken().getAccess_token();
            // 素材类型type有：voice(语音),video(视频),image(图片),news(图文)
            String type = "image";
            materialCount = MaterialApi.getMaterialCount(access_token);
            int result = MaterialManager.getMaterialCount(type, access_token);
            System.out.println(("获取素材总数成功！{}"+ result));
        } catch (Exception e) {
            System.out.println("获取图文素材失败！errcode:{} errmsg:{}"+materialCount.get("errcode")+":"+ materialCount.get("errmsg"));
        }
    }
}
