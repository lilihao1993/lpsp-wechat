package com.icinfo.lpsp.wechat.message.business.dto;
/**
 * 描述: 实时 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class WeatherRealtime {
	//实时风
	private RealtimeWind wind;
	//时间
	private String time;
	//实时天气
	private RealtimeWeather weather;
	//数据正常运行时间
	private String dataUptime;
	//日期
	private String date;
	//城市代码
	private String city_code;
	//城市名称
	private String city_name;
	//本月第几周
	private String week;
	//农历
	private String moon;
	public RealtimeWind getWind() {
		return wind;
	}
	public void setWind(RealtimeWind wind) {
		this.wind = wind;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public RealtimeWeather getWeather() {
		return weather;
	}
	public void setWeather(RealtimeWeather weather) {
		this.weather = weather;
	}
	public String getDataUptime() {
		return dataUptime;
	}
	public void setDataUptime(String dataUptime) {
		this.dataUptime = dataUptime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getMoon() {
		return moon;
	}
	public void setMoon(String moon) {
		this.moon = moon;
	}
}
