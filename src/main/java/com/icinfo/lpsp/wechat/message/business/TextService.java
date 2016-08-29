package com.icinfo.lpsp.wechat.message.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.lpsp.wechat.message.business.dto.GeocoderSearchResponse;
import com.icinfo.lpsp.wechat.message.business.dto.Position;
import com.icinfo.lpsp.wechat.message.business.dto.PositionAddress;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;
import java.net.URL;

/**
 * 描述：文本业务
 */
public class TextService {

    public static String Latitude = null;

    public static String Longitude = null;

    /**
     * 描述：响应文本
     *
     * @return
     */
    public static String responseTest(String content) throws Exception {
        if (content.length() > 3) {
            String str = content.substring(0, 4);
            String text = content.substring(content.indexOf(":") + 1);
            if ("百度百科".equals(str)) {
                return Dispatch.responseBaike(text);
            } else if ("天气预报".equals(str)) {
                return Dispatch.responseWeather(text);
            } else if ("今日星座".equals(str)) {
                return Dispatch.responseConstellatory(text);
            } else if ("本周星座".equals(str)) {
                return Dispatch.responseConstellatoryWeek(text);
            } else if ("历史今天".equals(content)) {
                return Dispatch.responseHistoryToday();
            } else if ("现代诗歌".equals(content)) {
                return Dispatch.responseModernPoetry();
            }
        }
        return content + "-- 来自服务器端的回复！";
    }

    /**
     * 描述：响应点击事件
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static String responseClick(String content) throws Exception {

        if ("HistoryToday".equals(content)) {
            return Dispatch.responseHistoryToday();
        } else if ("ModernPoetry".equals(content)) {
            return Dispatch.responseModernPoetry();
        } else if ("Weather".equals(content)) {
            if (Longitude != null) {
                URL url = new URL("http://api.map.baidu.com/geocoder?output=json&location=" + Latitude + "," + Longitude);
                InputStream inputStream = url.openStream();
                ObjectMapper objectMapper = new ObjectMapper();
                Position position = objectMapper.readValue(inputStream, Position.class);
                if ("OK".equals(position.getStatus())) {
                    return Dispatch.responseWeather(position.getResult().getAddressComponent().getCity());
                }
            }

        }
        return "~~出错了！";
    }

}
