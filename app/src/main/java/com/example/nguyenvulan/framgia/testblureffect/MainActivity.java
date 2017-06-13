package com.example.nguyenvulan.framgia.testblureffect;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.nguyenvulan.framgia.testblureffect.fragment.CommentFragment;

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
        mBottomNav.setOnClickListener(this);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_container, new CommentFragment());
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
        for (int i = 0; i < mBottomNav.getMenu().size(); i++) {
            MenuItem otherItem = mBottomNav.getMenu().getItem(i);
            if (otherItem.getItemId() != item.getItemId()) {
                switch (i) {
                    case 0:
                        otherItem.setIcon(ContextCompat.getDrawable(this, R.drawable.alarm));
                        Toast.makeText(this,"0",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        otherItem.setIcon(ContextCompat.getDrawable(this, R.drawable.heart));
                        Toast.makeText(this,"1",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        otherItem.setIcon(ContextCompat.getDrawable(this, R.drawable.compass));
                        Toast.makeText(this,"3",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        otherItem.setIcon(ContextCompat.getDrawable(this, R.drawable.profile));
                        Toast.makeText(this,"4",Toast.LENGTH_SHORT).show();
                        break;
                }

            }

        }
        return true;
    }
}
