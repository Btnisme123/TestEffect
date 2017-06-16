package com.example.nguyenvulan.framgia.testblureffect.data;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by FRAMGIA\nguyen.vu.lan on 16/06/2017.
 */

public class CustomMarker {
    private int mId;
    private String mText;
    private long Lat;
    private long Long;
    private LatLng mLatLng;

    public LatLng getLatLng() {
        return mLatLng;
    }

    public void setLatLng(LatLng latLng) {
        mLatLng = latLng;
    }

    public CustomMarker(int id, String text,LatLng latLng) {
        mId = id;
        mText = text;
        mLatLng = latLng;
    }

    public long getLong() {
        return Long;
    }

    public void setLong(long aLong) {
        Long = aLong;
    }

    public long getLat() {
        return Lat;
    }

    public void setLat(long lat) {
        Lat = lat;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
