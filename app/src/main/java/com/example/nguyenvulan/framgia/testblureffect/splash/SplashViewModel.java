package com.example.nguyenvulan.framgia.testblureffect.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;

import com.example.nguyenvulan.framgia.testblureffect.BR;
import com.example.nguyenvulan.framgia.testblureffect.activity.MainActivity;

/**
 * Created by FRAMGIA\nguyen.vu.lan on 21/06/2017.
 */

public class SplashViewModel extends BaseObservable {
    public boolean isFinished = false;

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
        notifyPropertyChanged(BR._all);
    }

    private static void setAnimation(final View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, View.SCALE_Y, 0.5f, 1f);
        objectAnimator.setDuration(3000);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ((view.getContext())).startActivity(new Intent(view.getContext(), MainActivity.class));
                ((Activity) (view.getContext())).finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        AnimatorSet animationSet = new AnimatorSet();
        animationSet.play(objectAnimator);
        animationSet.start();
    }

    @BindingAdapter("android:finish")
    public static void finishSplash(View view, boolean isFinished) {
        if (isFinished) {
            setAnimation(view);
        }
    }
}
