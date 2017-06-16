package com.example.nguyenvulan.framgia.testblureffect.data;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\nguyen.vu.lan on 16/06/2017.
 */

public class FakeContainer {
    public static List<CustomMarker> getCustomMarker() {
        List<CustomMarker> list = new ArrayList<>();
        CustomMarker customMarkerView1 = new CustomMarker(1, "TEXT0", new LatLng(-34, 151));
        CustomMarker customMarkerView2 = new CustomMarker(2, "TEXT1", new LatLng(-36, 151));
        CustomMarker customMarkerView3 = new CustomMarker(3, "TEXT2", new LatLng(-39, 151));
        CustomMarker customMarkerView4 = new CustomMarker(4, "TEXT3", new LatLng(-39, 160));
        CustomMarker customMarkerView5 = new CustomMarker(5, "TEXT4", new LatLng(-39, 140));
        CustomMarker customMarkerView6 = new CustomMarker(6, "TEXT5", new LatLng(-34, 145));
        CustomMarker customMarkerView7 = new CustomMarker(7, "TEXT6", new LatLng(-36, 155));
        list.add(customMarkerView1);
        list.add(customMarkerView2);
        list.add(customMarkerView3);
        list.add(customMarkerView4);
        list.add(customMarkerView5);
        list.add(customMarkerView6);
        list.add(customMarkerView7);
        return list;
    }
}
