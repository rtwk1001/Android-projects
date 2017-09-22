package com.example.lenovo.brtwk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * Created by Lenovo on 01-06-2016.
 */
public class Web extends Activity {
    WebView wv;

    ImageView search;
    ProgressBar progressBar;
    LinearLayout tool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);



 Intent in=getIntent();
        String urp=in.getStringExtra("key");
        wv=(WebView)findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(urp);
        wv.setWebViewClient(new WebViewClient());

        }
        public boolean onKeyDown( int keyCode, KeyEvent event) {
            if ((keyCode == KeyEvent.KEYCODE_BACK)) {
                if (wv.canGoBack()) {
                    wv.goBack();
                    return true;
                } else {
                    Intent back = new Intent(Web.this,Welcome.class);
                    back.putExtra("back", "abc");
                    startActivity(back);
                    finish();
                }}
                // If it wasn't the Back key or there's no web page history, bubble up to the default
                // system behavior (probably exit the activity)
                return super.onKeyDown(keyCode, event);
            }




        }





