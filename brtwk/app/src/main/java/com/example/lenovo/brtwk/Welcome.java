package com.example.lenovo.brtwk;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.widget.TabHost;

/**
 * Created by Lenovo on 05-06-2016.
 */


    public class Welcome extends TabActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //setContentView(R.layout.activity_main);

            TabHost mTabHost = getTabHost();


            mTabHost.addTab(mTabHost.newTabSpec("Home").setIndicator("Home").setContent(new Intent(this ,Home.class )));
            mTabHost.addTab(mTabHost.newTabSpec("Bookmarks").setIndicator("Bookmarks").setContent(new Intent(this  ,Bookmarks.class )));
            mTabHost.addTab(mTabHost.newTabSpec("Search").setIndicator("Search").setContent(new Intent(this ,Web.class )));
            mTabHost.setCurrentTab(0);



        }
    }



