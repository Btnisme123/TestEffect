package com.example.nguyenvulan.framgia.testblureffect.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nguyenvulan.framgia.testblureffect.R;

import jp.wasabeef.glide.transformations.BlurTransformation;


public class CommentFragment extends Fragment {
    private ImageView mImageView;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_comment, container, false);
        mImageView = (ImageView) mView.findViewById(R.id.image_test);
        Glide.with(getActivity()).load(R.drawable.sky)
            .bitmapTransform(new BlurTransformation(getActivity()))
            .into(mImageView);

        return mView;
    }


}
