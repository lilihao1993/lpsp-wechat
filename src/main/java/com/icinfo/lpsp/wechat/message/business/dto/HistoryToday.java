package com.icinfo.lpsp.wechat.message.business.dto;

import java.util.List;

/**
 * 描述: 历史今天 .<br>
 * @author lilihao
 * @date 2016年8月10日
 */
public class HistoryToday {
	//错误吗
	private String error_code;
	//信息
	private String reason;
	private List<HistroyParameter> result;
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<HistroyParameter> getResult() {
		return result;
	}
	public void setResult(List<HistroyParameter> result) {
		this.result = result;
	}
}
