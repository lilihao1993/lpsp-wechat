package com.icinfo.lpsp.wechat.message.business.dto;
/**
 * 描述: pm2.5信息 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class PM25 {
	private String curPm;
	private String pm25;
	private String pm10;
	//等级
	private String level;
	//质量
	private String quality;
	//提示
	private String des;
	public String getCurPm() {
		return curPm;
	}
	public void setCurPm(String curPm) {
		this.curPm = curPm;
	}
	public String getPm25() {
		return pm25;
	}
	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}
	public String getPm10() {
		return pm10;
	}
	public void setPm10(String pm10) {
		this.pm10 = pm10;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
}
