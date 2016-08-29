package com.icinfo.lpsp.wechat.message.business.dto;


import java.io.Serializable;

/**
 * 描述：地理位置
 */
public class Position implements Serializable{
    /**
     * 状态码
     */
    private String status;
    /**
     * 结果集
     */
    private PositionResult result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PositionResult getResult() {
        return result;
    }

    public void setResult(PositionResult result) {
        this.result = result;
    }
}
