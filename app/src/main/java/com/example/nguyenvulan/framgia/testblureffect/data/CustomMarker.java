package com.example.nguyenvulan.framgia.testblureffect.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by FRAMGIA\nguyen.vu.lan on 16/06/2017.
 */

public class CustomMarker implements Parcelable {
    private int mId;
    private String mText;
    private long Lat;
    private long Long;
    private LatLng mLatLng;

    protected CustomMarker(Parcel in) {
        mId = in.readInt();
        mText = in.readString();
        Lat = in.readLong();
        Long = in.readLong();
        mLatLng = in.readParcelable(LatLng.class.getClassLoader());
    }

    public static final Creator<CustomMarker> CREATOR = new Creator<CustomMarker>() {
        @Override
        public CustomMarker createFromParcel(Parcel in) {
            return new CustomMarker(in);
        }

        @Override
        public CustomMarker[] newArray(int size) {
            return new CustomMarker[size];
        }
    };

    public LatLng getLatLng() {
        return mLatLng;
    }

    public void setLatLng(LatLng latLng) {
        mLatLng = latLng;
    }

    public CustomMarker(int id, String text, LatLng latLng) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mText);
        dest.writeLong(Lat);
        dest.writeLong(Long);
        dest.writeParcelable(mLatLng, flags);
    }
}
