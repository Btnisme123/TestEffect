package com.example.nguyenvulan.framgia.testblureffect.termservice;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.nguyenvulan.framgia.testblureffect.BR;
import com.example.nguyenvulan.framgia.testblureffect.activity.MainActivity;

/**
 * Created by FRAMGIA\nguyen.vu.lan on 21/06/2017.
 */

public class TermModel extends BaseObservable {

    public String mWebUrl = "";

    public void setWebUrl(String webUrl) {
        mWebUrl = webUrl;
        notifyPropertyChanged(BR._all);
    }

    public String getWebUrl() {
        return mWebUrl;
    }

    public void onNextScreenClicked(View view) {
        ((view.getContext())).startActivity(new Intent(view.getContext(), MainActivity.class));
    }

    @BindingAdapter("android:bindUrl")
    public static void setUrl(View view, String url) {
        WebView webView = (WebView) view;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}
