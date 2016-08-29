package com.icinfo.lpsp.wechat.message.business.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 *
 */
public class GeocoderSearchResponse implements Serializable {
    @XStreamAlias("GeocoderSearchResponse")
    private Position geocoderSearchResponse;

    public Position getGeocoderSearchResponse() {
        return geocoderSearchResponse;
    }

    public void setGeocoderSearchResponse(Position geocoderSearchResponse) {
        this.geocoderSearchResponse = geocoderSearchResponse;
    }
}
