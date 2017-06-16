package com.example.nguyenvulan.framgia.testblureffect.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.nguyenvulan.framgia.testblureffect.R;
import com.example.nguyenvulan.framgia.testblureffect.data.CustomMarker;
import com.example.nguyenvulan.framgia.testblureffect.data.FakeContainer;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap;
    private ViewPager mViewPager;
    private List<CustomMarker> mMarkers = FakeContainer.getCustomMarker();
    private HashMap<Marker, CustomMarker> mList = new HashMap<>();
    private Marker mPreviousMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
            .findFragmentById(R.id.map);

    }


}
