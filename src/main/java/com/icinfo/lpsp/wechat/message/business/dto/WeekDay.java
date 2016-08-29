package com.icinfo.lpsp.wechat.message.business.dto;
/**
 * 描述: 当周某天信息 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class WeekDay {
	//阴历日期
	private String date;
	//信息
	private WeekDayInfo info;
	//周几
	private String week;
	//农历
	private  String nongli;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public WeekDayInfo getInfo() {
		return info;
	}
	public void setInfo(WeekDayInfo info) {
		this.info = info;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getNongli() {
		return nongli;
	}
	public void setNongli(String nongli) {
		this.nongli = nongli;
	}
}
