package com.icinfo.lpsp.wechat.message.business;


import com.icinfo.lpsp.wechat.message.bean.Article;
import com.icinfo.lpsp.wechat.message.business.dto.*;


import java.util.List;
import java.util.Random;

import static sun.plugin.javascript.navig.JSType.History;

/**
 * 描述: 字符串工具类 .<br>
 *
 * @author lilihao
 * @date 2016年8月8日
 */
public class StringUtil {

    /**
     * 描述: 天气信息整合 .
     *
     * @return
     * @author lilihao
     * @date 2016年8月8日
     */
    public static String WeatherIntegration(Weather weather) {
        StringBuilder str = new StringBuilder();
        if ("successed!".equals(weather.getReason())) {
            WeatherData data = weather.getResult().getData();
            str.append(data.getRealtime().getCity_name()).append("\n");
            str.append(data.getRealtime().getDate()).append(" " + data.getRealtime().getTime()).append("\n");
            str.append(data.getRealtime().getWeather().getInfo()).append("\n");
            str.append("实时温度:").append(data.getRealtime().getWeather().getTemperature()).append("℃").append("\n");
            str.append("温馨提示:").append(data.getLife().getInfo().getChuanyi().get(1));
        } else {
            str.append("您输入的格式有误,请重新输入!");
        }
        return str.toString();
    }

    /**
     * 描述: 历史今天整合 .
     *
     * @param historyToday
     * @return
     * @author lilihao
     * @date 2016年8月10日
     */
    public static String HistoryIntegration(HistoryToday historyToday) {
        StringBuilder content = new StringBuilder();

        /**
         * 增加一个标志 解决微信行数限制问题
         */
        int flg = historyToday.getResult().size();
        if (flg > 40) {
            flg = 39;
        }

        /**
         * 若错误吗为零则成功获取
         */
        if ("0".equals(historyToday.getError_code())) {

            for (int i = 0, j = historyToday.getResult().size(); i < flg; i++) {
                HistroyParameter history = historyToday.getResult().get(i);
                content.append(history.getYear() + "年").append(history.getMonth() + "月").append(history.getDay() + "日:").append(history.getTitle()).append("\n");
            }
        } else {
            content.append(historyToday.getReason());
        }
        return content.toString();
    }

    /**
     * 描述: 今日星座整合 .
     *
     * @param constellatory
     * @return
     * @author lilihao
     * @date 2016年8月10日
     */
    public static String toDayConstellatoryIntegration(Constellatory constellatory) {
        StringBuilder stringBuilder = new StringBuilder();
        //查询成功
        if ("0".equals(constellatory.getError_code())) {
            stringBuilder.append(constellatory.getName()).append("\n");
            stringBuilder.append("今日运势:").append(constellatory.getAll().charAt(0)).append("星\n");
            stringBuilder.append("恋爱指数:").append(constellatory.getLove().charAt(0)).append("星\n");
            stringBuilder.append("幸运数字:").append(constellatory.getNumber()).append("\n");
            stringBuilder.append("工作指数:").append(constellatory.getWork().charAt(0)).append("星\n");
            stringBuilder.append("温馨提示:").append(constellatory.getSummary());
        } else {
            stringBuilder.append("输入错误,请按照如下格式输入!\n");
            stringBuilder.append("今日星座:天枰座");
        }
        return stringBuilder.toString();
    }

    /**
     * 描述: 周星座整合 .
     *
     * @param constellatoryWeek
     * @return
     * @author lilihao
     * @date 2016年8月11日
     */
    public static String weekConstellatoryIntegration(ConstellatoryWeek constellatoryWeek) {
        StringBuilder stringBuilder = new StringBuilder();
        if ("0".equals(constellatoryWeek.getError_code())) {
            stringBuilder.append(constellatoryWeek.getName()).append("\n");
            stringBuilder.append(constellatoryWeek.getDate()).append("\n");
            stringBuilder.append(constellatoryWeek.getHealth().substring(0, constellatoryWeek.getHealth().length() - 6)).append("\n");
            stringBuilder.append(constellatoryWeek.getJob()).append("\n");
            stringBuilder.append(constellatoryWeek.getLove()).append("\n");
            stringBuilder.append(constellatoryWeek.getMoney()).append("\n");
            stringBuilder.append(constellatoryWeek.getWork()).append("\n");
        } else {
            stringBuilder.append("输入错误,请按照如下格式输入!\n");
            stringBuilder.append("本周星座:天秤座");
        }
        return stringBuilder.toString();
    }

    /**
     * 描述：整合新闻
     *
     * @param list
     * @return
     */
    public static void NewsIntegration(List<NewsDetail> list, Article article) {
        Random random = new Random();
        NewsDetail newsDetail = list.get(random.nextInt(list.size()));
        article.setTitle(newsDetail.getTitle());
        article.setDescription(newsDetail.getAuthor_name());
        article.setPicUrl(newsDetail.getThumbnail_pic_s03());
        article.setUrl(newsDetail.getUrl());
    }
}	
