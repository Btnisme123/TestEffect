package com.example.nguyenvulan.framgia.testblureffect.termservice;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nguyenvulan.framgia.testblureffect.R;
import com.example.nguyenvulan.framgia.testblureffect.databinding.ActivityTermBinding;

public class TermActivity extends AppCompatActivity {
    private ActivityTermBinding mActivityTermBinding;
    private TermModel mTermModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityTermBinding = DataBindingUtil.setContentView(this, R.layout.activity_term);
        mTermModel = new TermModel();
        mActivityTermBinding.setViewModel(mTermModel);
        mTermModel.setWebUrl("");
    }
}
