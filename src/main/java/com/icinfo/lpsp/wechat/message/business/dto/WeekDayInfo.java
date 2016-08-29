package com.icinfo.lpsp.wechat.message.business.dto;

import java.util.List;

/**
 * 描述: 一周某天信息 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class WeekDayInfo {
	//黎明
	List<String> dawn;
	//夜里
	List<String> night;
	//当天
	List<String> day;
	public List<String> getDawn() {
		return dawn;
	}
	public void setDawn(List<String> dawn) {
		this.dawn = dawn;
	}
	public List<String> getNight() {
		return night;
	}
	public void setNight(List<String> night) {
		this.night = night;
	}
	public List<String> getDay() {
		return day;
	}
	public void setDay(List<String> day) {
		this.day = day;
	}
	
}
