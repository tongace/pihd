
package com.dxc.toyota.application.pihd.master;

import java.util.List;


public class ShopListResponse {

    private List<Shop> shop;
    private List<TrackingPoint> trackingPoint;
    public List<Shop> getShop() {
        return shop;
    }
    public void setShop(List<Shop> shop) {
        this.shop = shop;
    }
    public List<TrackingPoint> getTrackingPoint() {
        return trackingPoint;
    }
    public void setTrackingPoint(List<TrackingPoint> trackingPoint) {
        this.trackingPoint = trackingPoint;
    }

}
