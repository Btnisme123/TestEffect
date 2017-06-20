package com.example.nguyenvulan.framgia.testblureffect.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nguyenvulan.framgia.testblureffect.R;


public class CommentFragment extends Fragment {
    private ImageView mImageView;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_comment, container, false);


        return mView;
    }


}
