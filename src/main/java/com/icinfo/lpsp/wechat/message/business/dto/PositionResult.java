package com.icinfo.lpsp.wechat.message.business.dto;

import java.io.Serializable;

/**
 * 描述：地理位置结果集
 */
public class PositionResult implements Serializable {

    /**
     * 地址
     */
    private String formatted_address;
    /**
     *
     */
    private String business;
    /**
     * 经纬度
     */
    private PositionLocation location;
    /**
     * 地址信息
     */

    private PositionAddress addressComponent;
    /**
     * 城市编号
     */
    private String cityCode;

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public PositionLocation getLocation() {
        return location;
    }

    public void setLocation(PositionLocation location) {
        this.location = location;
    }

    public PositionAddress getAddressComponent() {
        return addressComponent;
    }

    public void setAddressComponent(PositionAddress addressComponent) {
        this.addressComponent = addressComponent;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }


}
