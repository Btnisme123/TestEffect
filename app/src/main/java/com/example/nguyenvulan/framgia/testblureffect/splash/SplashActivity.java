package com.example.nguyenvulan.framgia.testblureffect.splash;

import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.example.nguyenvulan.framgia.testblureffect.R;
import com.example.nguyenvulan.framgia.testblureffect.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding mActivitySplashBinding;
    private SplashViewModel mSplashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        mSplashViewModel = new SplashViewModel();
        mActivitySplashBinding.setViewModel(mSplashViewModel);
        init();
    }

    private void init() {
        mSplashViewModel.setIsFinished(true);

//        Handler mHandler = new Handler(Looper.myLooper());
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 3000);
    }

}
