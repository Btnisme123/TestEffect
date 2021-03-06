package com.example.nguyenvulan.framgia.testblureffect.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.nguyenvulan.framgia.testblureffect.R;
import com.example.nguyenvulan.framgia.testblureffect.fragment.CardFragment;
import com.example.nguyenvulan.framgia.testblureffect.fragment.MapFragment;
import com.example.nguyenvulan.framgia.testblureffect.viewpager.VerticalViewPager;
import com.example.nguyenvulan.framgia.testblureffect.viewpager.ViewPagerAdapter;

public class DetailActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    VerticalViewPager mVerticalViewPager;
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
    }

    private void init() {
        mVerticalViewPager = (VerticalViewPager) findViewById(R.id.view_pager);
        mViewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        for (int i = 0; i < MapFragment.sMarkers.size(); i++) {
            CardFragment cardFragment = new CardFragment();
            cardFragment.setPosition(i);
            mViewPagerAdapter.addFragment(cardFragment);
        }
        mVerticalViewPager.setAdapter(mViewPagerAdapter);
        mVerticalViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
