package com.example.lenovo.rtwk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
WebView wv;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.b);
        wv=(WebView)findViewById(R.id.wv);
        wv.loadUrl("http://ritsssishere.wixsite.com/rtwk1001");
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b.getText().toString().length()>=10) {
                    wv.loadUrl("https://github.com/rtwk1001");
                    wv.getSettings().setJavaScriptEnabled(true);
                    b.setText("Back", TextView.BufferType.NORMAL);
                    wv.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                }
                else{
                    wv.loadUrl("http://ritsssishere.wixsite.com/rtwk1001");
                    wv.getSettings().setJavaScriptEnabled(true);
                    b.setText("My project profile", TextView.BufferType.NORMAL);
                    wv.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                }
            }
        });

    }
}
