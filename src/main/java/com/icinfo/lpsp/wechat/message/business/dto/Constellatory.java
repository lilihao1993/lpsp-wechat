package com.icinfo.lpsp.wechat.message.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 描述: 星座dto .<br>
 * @author lilihao
 * @date 2016年8月10日
 */
//此注解用于忽略未知
@JsonIgnoreProperties(ignoreUnknown = true)  
public class Constellatory {
	//日期
	private String date;
	//星座名称
	private String name;
	//中文日期
	private String datetime;
	//今日运势
	private String all;
	//颜色
	private String color;
	//健康程度
	private String health;
	//爱情指数
	private String love;
	//金钱指数
	private String money;
	//幸运数字
	private String number;
	//最佳星友
	private String QFriend;
	//总结
	private String summary;
	//工作指数
	private String work;
	//结果码
	private String resultcode;
	//错误码
	private String error_code;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getQFriend() {
		return QFriend;
	}
	public void setQFriend(String QFriend) {
		this.QFriend = QFriend;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getResultcode() {
		return resultcode;
	}
	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
}
