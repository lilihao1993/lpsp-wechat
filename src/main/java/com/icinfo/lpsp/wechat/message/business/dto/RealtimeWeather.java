package com.icinfo.lpsp.wechat.message.business.dto;
/**
 * 描述: 实时天气 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class RealtimeWeather {
	//湿度
	private String humidity;
	//图片
	private String img;
	//信息（多云 晴天 雷雨天....）
	private String info;
	//温度
	private String temperature;
	
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
}
