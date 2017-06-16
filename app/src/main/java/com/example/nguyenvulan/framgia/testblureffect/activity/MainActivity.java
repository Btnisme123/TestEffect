package com.example.nguyenvulan.framgia.testblureffect.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.nguyenvulan.framgia.testblureffect.R;
import com.example.nguyenvulan.framgia.testblureffect.fragment.CommentFragment;
import com.example.nguyenvulan.framgia.testblureffect.fragment.ContactFragment;
import com.example.nguyenvulan.framgia.testblureffect.fragment.MapFragment;
import com.example.nguyenvulan.framgia.testblureffect.fragment.SettingFragment;
import com.example.nguyenvulan.framgia.testblureffect.util.BottomNavigationHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mBottomNav;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        BottomNavigationHelper.disableShiftMode(mBottomNav);
        mBottomNav.setOnNavigationItemSelectedListener(this);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        MenuItem mainItem = mBottomNav.getMenu().getItem(2);
        if (item.getItemId() != mainItem.getItemId()) {
            item.setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
        }
        switch (item.getItemId()){
            case R.id.item_alarm:
                item.setIcon(ContextCompat.getDrawable(this, R.drawable.alarm));
                replaceFragment(new CommentFragment());
                break;
            case R.id.item_heart:
                item.setIcon(ContextCompat.getDrawable(this, R.drawable.heart));
                replaceFragment(new ContactFragment());
                break;
            case R.id.item_compass:
                item.setIcon(ContextCompat.getDrawable(this, R.drawable.compass));
                replaceFragment(new MapFragment());
                break;
            case R.id.item_profile:
                item.setIcon(ContextCompat.getDrawable(this, R.drawable.profile));
                replaceFragment(new SettingFragment());
                break;
        }
        Log.e("", "vao day");
        return true;
    }
}
