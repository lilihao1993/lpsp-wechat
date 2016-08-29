package com.icinfo.lpsp.wechat.message.business.dto;
/**
 * 描述: 生活 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class WeatherLife {
	/**
	 * 日期
	 */
	private String date;
	/**
	 * 生活信息
	 */
	private LifeInfo info;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public LifeInfo getInfo() {
		return info;
	}
	public void setInfo(LifeInfo info) {
		this.info = info;
	}
}
