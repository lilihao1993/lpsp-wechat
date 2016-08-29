package com.icinfo.lpsp.wechat.message.business.dto;
/**
 * 描述: 实时风 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class RealtimeWind {
	//风速
	private String windspeed;
	//风向
	private String direct;
	//等级
	private String power;
	//偏移
	private String offset;
	public String getWindspeed() {
		return windspeed;
	}
	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
	}
	public String getDirect() {
		return direct;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
	
}
