package com.example.nguyenvulan.framgia.testblureffect.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(idLayout());
        initView();
        initData();
    }

    protected abstract int idLayout();

    protected abstract void initView();

    protected abstract void initData();


}
