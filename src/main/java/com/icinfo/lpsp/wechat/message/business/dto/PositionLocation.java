package com.icinfo.lpsp.wechat.message.business.dto;

import java.io.Serializable;

/**
 * 描述：地理位置 经纬度
 */
public class PositionLocation implements Serializable {
    /**
     *纬度
     */
    private String lat;
    /**
     * 经度
     */
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
