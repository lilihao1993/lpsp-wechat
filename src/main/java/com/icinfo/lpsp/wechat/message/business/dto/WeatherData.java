package com.icinfo.lpsp.wechat.message.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * 描述: 数据 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
	//实时
	private WeatherRealtime realtime;
	//生活
	private WeatherLife  life; 
	//天气
	private List<WeekDay> weather;
	//pm2.5
	private WeatherPM pm25;
	//时间
	private String date;
	//是否是国外
	//0:不在国外
	//1:在国外
	String  isForeign;

	public WeatherRealtime getRealtime() {
		return realtime;
	}

	public void setRealtime(WeatherRealtime realtime) {
		this.realtime = realtime;
	}

	public WeatherLife getLife() {
		return life;
	}

	public void setLife(WeatherLife life) {
		this.life = life;
	}


	public WeatherPM getPm25() {
		return pm25;
	}

	public void setPm25(WeatherPM pm25) {
		this.pm25 = pm25;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIsForeign() {
		return isForeign;
	}

	public void setIsForeign(String isForeign) {
		this.isForeign = isForeign;
	}

	public List<WeekDay> getWeather() {
		return weather;
	}

	public void setWeather(List<WeekDay> weather) {
		this.weather = weather;
	}
	
}
