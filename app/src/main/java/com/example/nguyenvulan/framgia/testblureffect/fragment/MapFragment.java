package com.example.nguyenvulan.framgia.testblureffect.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyenvulan.framgia.testblureffect.R;
import com.example.nguyenvulan.framgia.testblureffect.data.CustomMarker;
import com.example.nguyenvulan.framgia.testblureffect.data.FakeContainer;
import com.example.nguyenvulan.framgia.testblureffect.util.CardFragmentPagerAdapter;
import com.example.nguyenvulan.framgia.testblureffect.util.ShadowTransformer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, ViewPager.OnPageChangeListener {
    private MapView mMap;
    private ViewPager mViewPager;
    public static List<CustomMarker> sMarkers = FakeContainer.getCustomMarker();
    private HashMap<Marker, CustomMarker> mList = new HashMap<>();
    private Marker mPreviousMarker;
    private View mView;
    private GoogleMap mGoogleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_map, container, false);
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);
        mMap = (MapView) mView.findViewById(R.id.mapView);
        mMap.onCreate(savedInstanceState);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        mMap.getMapAsync(this);
        super.onActivityCreated(savedInstanceState);
    }

    private void init() {
        CardFragmentPagerAdapter cardFragmentPagerAdapter =
            new CardFragmentPagerAdapter(getFragmentManager(), dpToPixels(2, getActivity()), sMarkers.size());
        ShadowTransformer shadowTransformer = new ShadowTransformer(mViewPager, cardFragmentPagerAdapter);
        shadowTransformer.enableScaling(true);
        mViewPager.setAdapter(cardFragmentPagerAdapter);
        mViewPager.setPageTransformer(false, shadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        for (CustomMarker customMarker : sMarkers) {
            drawMarker(customMarker);
        }
        mViewPager.addOnPageChangeListener(this);
    }

    private void drawMarker(CustomMarker customMarker) {
        LatLng latLng = customMarker.getLatLng();
        Marker marker = mGoogleMap.addMarker(
            new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon))
                .position(latLng).
                title(customMarker.getText()));
        mList.put(marker, customMarker);
    }

    private float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        init();
        mGoogleMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        CustomMarker customMarker = mList.get(marker);
        changIconMarker(marker);
        mViewPager.setCurrentItem(customMarker.getId());
        return false;
    }

    private void changIconMarker(Marker marker) {
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

    @Override
    public void onResume() {
        super.onResume();
        mMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMap.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMap.onDestroy();
    }

    private void changeMarkerPosition(int position) {
        if (position >= 0 && position < mList.size()) {
            CustomMarker customMarker = sMarkers.get(position);
            for (Map.Entry<Marker, CustomMarker> entry : mList.entrySet()) {
                if (customMarker.getLatLng().equals(entry.getValue().getLatLng())) {
                    changIconMarker(entry.getKey());
                    mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(customMarker.getLatLng(), 5));
                }
            }
        }
    }
}
