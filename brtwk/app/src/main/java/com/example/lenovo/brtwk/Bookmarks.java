package com.example.lenovo.brtwk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lenovo on 01-06-2016.
 */
public class Bookmarks extends Activity {
    ImageView fb, google, insta, youtube, twitter, earth, gplus, gmail, whether, whatsapp, skype, yahoo, linkedin, search, menu, br1;

    TextView tv1;
    SharedPreferences sp;
    String email, password;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmarks);


        fb = (ImageView) findViewById(R.id.facebook);



        google = (ImageView) findViewById(R.id.google);
        insta = (ImageView) findViewById(R.id.instagram);
        youtube = (ImageView) findViewById(R.id.youtube);
        twitter = (ImageView) findViewById(R.id.twitter);
        linkedin = (ImageView) findViewById(R.id.linkedin);
        yahoo = (ImageView) findViewById(R.id.yahoo);
        earth = (ImageView) findViewById(R.id.earth);
        gmail = (ImageView) findViewById(R.id.gmail);
        gplus = (ImageView) findViewById(R.id.gplus);
        skype = (ImageView) findViewById(R.id.skype);
        whatsapp = (ImageView) findViewById(R.id.whatsapp);
        whether = (ImageView) findViewById(R.id.whether);





        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://www.facebook.com");
                startActivity(web);
                finish();
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://www.google.co.in");
                startActivity(web);
                finish();
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://www.instagram.com");
                startActivity(web);
                finish();
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://www.youtube.com");
                startActivity(web);
                finish();
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://www.twitter.com");
                startActivity(web);
                finish();
            }
        });
        whether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "http://www.accuweather.com/en/in/india-weather");
                startActivity(web);
                finish();
            }
        });
        skype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://web.skype.com");
                startActivity(web);
                finish();
            }
        });
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://mail.google.com/");
                startActivity(web);
                finish();
            }
        });
        gplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://plus.google.com/");
                startActivity(web);
                finish();
            }
        });
        earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://maps.google.com/");
                startActivity(web);
                finish();
            }
        });
        yahoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://www.yahoo.com");
                startActivity(web);
                finish();
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://www.whatsapp.com");
                startActivity(web);
                finish();
            }
        });
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Bookmarks.this, Web.class);
                web.putExtra("key", "https://www.linkedin.com");
                startActivity(web);
                finish();
            }
        });
    }
}
