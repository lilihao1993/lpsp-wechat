package com.icinfo.lpsp.wechat.message.business.dto;

import java.util.List;

/**
 * 描述: 生活信息 .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class LifeInfo {
	/**
	 * 空调信息
	 */
	private List<String> kongtiao;
	
	/**
	 * 运动信息
	 */
	private List<String> yundong;
	
	/**
	 * 紫外线信息
	 */
	private List<String> ziwaixian;
	/**
	 *  感冒信息
	 */
	private List<String> ganmao;
	
	/**
	 *  洗车
	 */
	private List<String> xiche;
	
	/**
	 * 污染
	 */
	private List<String> wuran;
	
	/**
	 * 穿衣
	 */
	private List<String> chuanyi;

	public List<String> getKongtiao() {
		return kongtiao;
	}

	public void setKongtiao(List<String> kongtiao) {
		this.kongtiao = kongtiao;
	}

	public List<String> getYundong() {
		return yundong;
	}

	public void setYundong(List<String> yundong) {
		this.yundong = yundong;
	}

	public List<String> getZiwaixian() {
		return ziwaixian;
	}

	public void setZiwaixian(List<String> ziwaixian) {
		this.ziwaixian = ziwaixian;
	}

	public List<String> getGanmao() {
		return ganmao;
	}

	public void setGanmao(List<String> ganmao) {
		this.ganmao = ganmao;
	}

	public List<String> getXiche() {
		return xiche;
	}

	public void setXiche(List<String> xiche) {
		this.xiche = xiche;
	}

	public List<String> getWuran() {
		return wuran;
	}

	public void setWuran(List<String> wuran) {
		this.wuran = wuran;
	}

	public List<String> getChuanyi() {
		return chuanyi;
	}

	public void setChuanyi(List<String> chuanyi) {
		this.chuanyi = chuanyi;
	}
}
