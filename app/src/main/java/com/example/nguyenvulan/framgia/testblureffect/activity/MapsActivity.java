package com.example.nguyenvulan.framgia.testblureffect.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.nguyenvulan.framgia.testblureffect.R;

import rx.Observable;


public class MapsActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

    }

/*
    public boolean isGrayScale(Bitmap myImage) {
        boolean isGrayScaleImage = true;
        int myHeight = myImage.getHeight();
        int myWidth = myImage.getWidth();

        for (int i = 0; i < myHeight; i++) {
            for (int j = 0; j < myWidth; j++) {
                int currentPixel = myImage.getPixel(i, j);

            }
        }
    }


    boolean isGrayScalePixel(int pixel){

        int alpha = (pixel && 0xFF000000) >> 24;
        int red   = (pixel && 0x00FF0000) >> 16;
        int green = (pixel && 0x0000FF00) >> 8;
        int blue  = (pixel && 0x000000FF);

        if( 0 == alpha && red == green && green == blue ) return true;
        else return false;

    }
    */
}
