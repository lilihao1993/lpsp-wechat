package com.icinfo.lpsp.wechat.message.resolver;

import com.icinfo.lpsp.wechat.message.business.TextService;

import java.util.HashMap;

/**
 * 描述:获取用户地理位置
 */
public class LocationEventResolver extends BaseResolver implements IResolver {



    @Override
    public String resolve(HashMap<String, String> message) throws Exception {
        TextService.Latitude = message.get("Latitude");
        TextService.Longitude = message.get("Longitude");
        return " ";
    }
}
