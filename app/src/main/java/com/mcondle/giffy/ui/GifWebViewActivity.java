package com.mcondle.giffy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.mcondle.giffy.R;

/**
 * Created by mandeep.condle on 5/18/17.
 */

public class GifWebViewActivity extends AppCompatActivity {

    public static final String KEY_GIF_URL = "KEY_GIF_URL";

    private WebView gifWebView;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gif_web_layout);

        this.url = getIntent().getStringExtra(KEY_GIF_URL);
        gifWebView = (WebView) findViewById(R.id.gif_web_view);
        gifWebView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gifWebView.loadUrl(url);
    }
}
