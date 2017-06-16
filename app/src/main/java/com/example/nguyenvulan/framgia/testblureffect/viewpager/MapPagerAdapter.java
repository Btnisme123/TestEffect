package com.example.nguyenvulan.framgia.testblureffect.viewpager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by FRAMGIA\nguyen.vu.lan on 14/06/2017.
 */

public class MapPagerAdapter extends PagerAdapter {
    private Context mContext;

    public MapPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView textView = new TextView(mContext);
        textView.setText("Item " + position);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.BLACK);
        container.addView(textView);
        return container;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
