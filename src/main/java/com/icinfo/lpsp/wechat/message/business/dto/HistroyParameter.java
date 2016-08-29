package com.icinfo.lpsp.wechat.message.business.dto;

public class HistroyParameter {
	/**
	 * id
	 */
	private String _id;
	/**
	 * 天
	 */
	private String day;
	/**
	 * 说明
	 */
	private String des;
	/**
	 * 阴历
	 */
	private String lunar;
	/**
	 * 月份
	 */
	private String month;
	/**
	 * 图片
	 */
	private String pic;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 年
	 */
	private String year;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getLunar() {
		return lunar;
	}
	public void setLunar(String lunar) {
		this.lunar = lunar;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "HistroyParameter{" +
				"_id='" + _id + '\'' +
				", day='" + day + '\'' +
				", des='" + des + '\'' +
				", lunar='" + lunar + '\'' +
				", month='" + month + '\'' +
				", pic='" + pic + '\'' +
				", title='" + title + '\'' +
				", year='" + year + '\'' +
				'}';
	}
}
