package com.icinfo.lpsp.wechat.message.business.dto;

/**
 * 描述：新闻
 */
public class News {
    /**
     * 结果信息
     */
    private String reason;

    /**
     * 新闻结果集
     */
    private NewsResult result;

    /**
     *错误码
     */
    private int  error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public NewsResult getResult() {
        return result;
    }

    public void setResult(NewsResult result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
