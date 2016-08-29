package com.icinfo.lpsp.wechat.message.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.icinfo.lpsp.wechat.message.business.dto.*;
import org.aspectj.bridge.MessageUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

/**
 * 描述:调度类    用于接收微信文本，执行响应功能 .<br>
 *
 * @author lilihao
 * @date 2016年8月4日
 */
public class Dispatch {

    /**
     * 描述: 响应用户信息类型 .
     *
     * @throws IOException
     * @author lilihao
     * @date 2016年8月4日
     */
    public static String responseBaike(String str) throws IOException {
        String url = "http://baike.baidu.com/search/word?word=" + str;
        // 从 URL 直接加载 HTML 文档
        Document doc = Jsoup.connect(url).get();
        // 获取Elements内容集合
        Elements contentDiv = doc.getElementsByClass("lemma-summary");
        String content = contentDiv.text();
        if (content.equals("")) {
            return "请换个词条重新再试";
        } else if (content.length() > 701) {
            return content.substring(0, 700).replaceAll(" ", "").toString();
        } else {
            return content.replaceAll(" ", "").toString();
        }
    }

    /**
     * 描述: 响应天气预报 .
     *
     * @param str
     * @return
     * @throws IOException
     * @author lilihao
     * @date 2016年8月8日
     */
    public static String responseWeather(String str) throws IOException {
        URL url = new URL("http://op.juhe.cn/onebox/weather/query?key=4303dc78d1a41e1058c70be70638f346&cityname=" + str);
        InputStream inputStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String json = reader.readLine();
        ObjectMapper object = new ObjectMapper();
        Weather weather = object.readValue(json, Weather.class);
        return StringUtil.WeatherIntegration(weather);
    }


    /**
     * 描述: 响应历史今天 .
     *
     * @return
     * @throws IOException
     * @author lilihao
     * @date 2016年8月10日
     */
    public static String responseHistoryToday() throws IOException {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String connect = "http://api.juheapi.com/japi/toh?key=e42f8509b23c9e7d7792a1e1ae281066&v=1.0&month=" + month + "&day=" + day;
        URL url = new URL(connect);
        InputStream inputStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String json = reader.readLine();
        ObjectMapper object = new ObjectMapper();
        HistoryToday historyToday = object.readValue(json, HistoryToday.class);
        return StringUtil.HistoryIntegration(historyToday);
    }

    /**
     * 描述: 响应今日星座 .
     *
     * @return
     * @throws IOException
     * @author lilihao
     * @date 2016年8月10日
     */
    public static String responseConstellatory(String str) throws IOException {
        String connect = "http://web.juhe.cn:8080/constellation/getAll?type=today&key=67955d8fc9c151270c4dd8bc791c7b36&consName=" + str;
        System.out.println(connect);
        URL url = new URL(connect);
        InputStream inputStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String json = reader.readLine();
        System.out.println(json);
        ObjectMapper object = new ObjectMapper();
        Constellatory constellatory = object.readValue(json, Constellatory.class);
        return StringUtil.toDayConstellatoryIntegration(constellatory);
    }

    /**
     * 描述: 响应本周星座 .
     *
     * @param str
     * @return
     * @throws Exception
     * @author lilihao
     * @date 2016年8月11日
     */
    public static String responseConstellatoryWeek(String str) throws Exception {
        String connect = "http://web.juhe.cn:8080/constellation/getAll?type=week&key=67955d8fc9c151270c4dd8bc791c7b36&consName=" + str;
        URL url = new URL(connect);
        InputStream inputStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String json = reader.readLine();
        System.out.println(json);
        ObjectMapper object = new ObjectMapper();
        ConstellatoryWeek constellatoryWeek = object.readValue(json, ConstellatoryWeek.class);
        return StringUtil.weekConstellatoryIntegration(constellatoryWeek);
    }

    /**
     * 描述: 响应现代诗 .
     *
     * @return
     * @throws IOException
     * @author lilihao
     * @date 2016年8月11日
     */
    public static String responseModernPoetry() throws IOException {
        Random ra = new Random();
        List<String> list = new ArrayList<>(1248);
        for (int i = 1; i < 13; i++) {
            String connent = "http://www.52shici.com/poetrys.php?page=" + i;
            Document doc = Jsoup.connect(connent).get();
            Elements link = doc.select("a");
            for (Element element : link) {
                String str = element.attr("href");
                if (str.contains("posts.php?id=")) {
                    list.add(str.substring(str.indexOf('='), str.length()));
                }
            }
        }
        int a = ra.nextInt(1248);
        String connent = "http://www.52shici.com/posts.php?id" + list.get(a);
        Document doc = Jsoup.connect(connent).get();
        Elements elements = doc.getElementsByClass("posts-content");
        String content = elements.text().substring(0, elements.text().indexOf("举报")).replaceAll(" ", "\n");
        return content.trim();
    }

    /**
     * 描述：获取音乐
     *
     * @param type
     * @return
     */
    public static MusicSong responseMusic(String type) throws Exception {
        String connect = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&size=10&offset=0&type=" + type;
        URL url = new URL(connect);
        InputStream inputStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String json = reader.readLine();
        System.out.println(json);
        ObjectMapper object = new ObjectMapper();
        Music music = object.readValue(json, Music.class);
        List<MusicSong> list = music.getSong_list();
        Random random = new Random();
        return list.get(random.nextInt(list.size()-1));
    }

    public static String  responseMusic1(String id)throws Exception{
        String connect = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.song.play&songid="+id;
        URL url = new URL(connect);
        InputStream inputStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String json = reader.readLine();
        ObjectMapper object = new ObjectMapper();
        MusicAd musicAd = object.readValue(json, MusicAd.class);
        return musicAd.getBitrate().getFile_link();
    }

}