package com.icinfo.lpsp.wechat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.lpsp.wechat.common.utils.ConfigUtils;
import com.icinfo.lpsp.wechat.common.utils.WechatUploadUtil;
import com.icinfo.lpsp.wechat.message.business.Dispatch;
import com.icinfo.lpsp.wechat.message.business.dto.*;
import com.icinfo.lpsp.wechat.token.Token;
import com.icinfo.lpsp.wechat.token.TokenAPI;
import com.icinfo.lpsp.wechat.token.TokenManager;
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
        System.out.println(WechatUploadUtil.upload1(TokenManager.getToken().getAccess_token(), "F:\\test.jpeg", "image"));
    }
}
