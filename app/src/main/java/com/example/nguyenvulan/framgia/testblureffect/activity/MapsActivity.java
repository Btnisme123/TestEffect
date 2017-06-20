package com.example.nguyenvulan.framgia.testblureffect.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nguyenvulan.framgia.testblureffect.R;


public class MapsActivity extends FragmentActivity {
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mImageView = (ImageView) findViewById(R.id.image_test);
        mImageView.setImageResource(R.drawable.panda);
        Bitmap bitmap;
        if (mImageView.getDrawable() instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) mImageView.getDrawable()).getBitmap();
        } else {
            Drawable d = mImageView.getDrawable();
            bitmap = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            d.draw(canvas);
        }
        if (isGrayScale(bitmap)) {
            Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "false", Toast.LENGTH_LONG).show();
        }
    }


    public boolean isGrayScale(Bitmap myImage) {
        boolean isGrayScaleImage = true;
        int myHeight = myImage.getHeight();
        int myWidth = myImage.getWidth();
        Log.e(" width ", "Width  : " + myWidth);
        try {
            for (int i = 0; i < myHeight; i++) {
                for (int j = 0; j < myHeight; j++) {
                    int currentPixel = myImage.getPixel(i, j);
                    Log.e("i : " + i, "J : " + j);
                    if (isGrayScalePixel(currentPixel)) {
                        isGrayScaleImage = false;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            Log.e("", "" + e.getMessage());
        }

        return isGrayScaleImage;
    }


    boolean isGrayScalePixel(int pixel) {

        int alpha = (pixel & 0xFF000000) >> 24;
        int red = (pixel & 0x00FF0000) >> 16;
        int green = (pixel & 0x0000FF00) >> 8;
        int blue = (pixel & 0x000000FF);

        if (0 == alpha && red == green && green == blue) return true;
        else return false;

    }

}
