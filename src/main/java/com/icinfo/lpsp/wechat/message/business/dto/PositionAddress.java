package com.icinfo.lpsp.wechat.message.business.dto;

import java.io.Serializable;

/**
 *描述：地址
 */
public class PositionAddress implements Serializable {
    /**
     *街道
     */
    private String street;
    /**
     * 区
     */
    private String district;
    /**
     * 城市
     */
    private String city;
    /**
     * 省
     */
    private String province;
    /**
     * 方向
     */
    private String direction;
    /**
     * 距离
     */
    private String distance;
    /**
     * 门牌号码
     */
    private String street_number;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }
}
