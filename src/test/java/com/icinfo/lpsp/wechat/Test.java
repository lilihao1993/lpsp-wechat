package com.icinfo.lpsp.wechat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.lpsp.wechat.common.utils.ConfigUtils;
import com.icinfo.lpsp.wechat.message.business.Dispatch;
import com.icinfo.lpsp.wechat.message.business.dto.*;
import com.icinfo.lpsp.wechat.token.Token;
import com.icinfo.lpsp.wechat.token.TokenAPI;
import com.thoughtworks.xstream.XStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by Administrator on 2016/8/18.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://op.juhe.cn/onebox/weather/query?key=4303dc78d1a41e1058c70be70638f346&cityname=北京");
        InputStream inputStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String json = reader.readLine();
        ObjectMapper object = new ObjectMapper();
        Map<Object,Object> map = object.readValue(json, Map.class);
        WeatherResult str = (WeatherResult )map.get("result");
        System.out.println(str.getData().getDate());
    }
}
