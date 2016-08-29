package com.icinfo.lpsp.wechat.message.business.dto;

/**
 * 描述: PM2.5 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class WeatherPM {
	//key
	private String key;
	//显示属性
	private String show_desc;
	//PM2.5属性
	private PM25 pm25;
	//日期时间
	private String dateTime;
	//城市
	private String cityName;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getShow_desc() {
		return show_desc;
	}
	public void setShow_desc(String show_desc) {
		this.show_desc = show_desc;
	}
	public PM25 getPm25() {
		return pm25;
	}
	public void setPm25(PM25 pm25) {
		this.pm25 = pm25;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
