package com.icinfo.lpsp.wechat.message.business.dto;
/**
 * 描述: 天气转换Model .<br>
 * @author lilihao
 * @date 2016年8月8日
 */
public class Weather {
	//是否调用成功
	private String reason;
	//调用结果
	private WeatherResult result;
	//错误码
	private String error_code;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public WeatherResult getResult() {
		return result;
	}
	public void setResult(WeatherResult result) {
		this.result = result;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	
}
