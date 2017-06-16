package com.example.nguyenvulan.framgia.testblureffect.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.nguyenvulan.framgia.testblureffect.R;
import com.example.nguyenvulan.framgia.testblureffect.data.CustomMarker;
import com.example.nguyenvulan.framgia.testblureffect.data.FakeContainer;
import com.example.nguyenvulan.framgia.testblureffect.util.CardFragmentPagerAdapter;
import com.example.nguyenvulan.framgia.testblureffect.util.ShadowTransformer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, ViewPager.OnPageChangeListener {

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
        mapFragment.getMapAsync(this);
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        CardFragmentPagerAdapter cardFragmentPagerAdapter =
            new CardFragmentPagerAdapter(getSupportFragmentManager(), dpToPixels(2, this),mMarkers.size());
        ShadowTransformer shadowTransformer = new ShadowTransformer(mViewPager, cardFragmentPagerAdapter);
        shadowTransformer.enableScaling(true);
        mViewPager.setAdapter(cardFragmentPagerAdapter);
        mViewPager.setPageTransformer(false, shadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        for (CustomMarker customMarker : mMarkers) {
            drawMarker(customMarker);
        }
        mViewPager.addOnPageChangeListener(this);
    }

    private void drawMarker(CustomMarker customMarker) {
        LatLng latLng = customMarker.getLatLng();
        Marker marker = mMap.addMarker(
            new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon))
                .position(latLng).
                title(customMarker.getText()));
        mList.put(marker, customMarker);
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        init();
        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        CustomMarker customMarker = mList.get(marker);
        changIconMarker(customMarker, marker);
        mViewPager.setCurrentItem(customMarker.getId());
        return false;
    }

    private void changIconMarker(CustomMarker customMarker, Marker marker) {
        if (mPreviousMarker != null) {
            mPreviousMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.icon));
        }
        marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_marker));
        mPreviousMarker = marker;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeMarkerPosition(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void changeMarkerPosition(int position) {
        if (position >= 0 && position < mList.size()) {
            CustomMarker customMarker = mMarkers.get(position);
            for (Map.Entry<Marker, CustomMarker> entry : mList.entrySet()) {
                if (customMarker.getLatLng().equals(entry.getValue().getLatLng())) {
                    changIconMarker(customMarker, entry.getKey());
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(customMarker.getLatLng(), 5));
                }
            }
        }

    }
}
