package com.example.lenovo.jokes;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Lenovo on 07-06-2016.
 */
public class admin extends Activity {
SQLiteDatabase db;

    Button submit,new_entry, back;
    Spinner sp;
    String ratings,feed;
    EditText Feed;
    ArrayAdapter<String> adapter;
    String[] cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        db = openOrCreateDatabase("jokedb ",MODE_PRIVATE,null);
        submit=(Button)findViewById(R.id.submit);
        new_entry=(Button)findViewById(R.id.Entry);
        sp = (Spinner) findViewById(R.id.cat);
        back =(Button)findViewById(R.id.Back);
        Feed = (EditText)findViewById(R.id.joke);
        db.execSQL("Create Table If Not Exists Feed(ratings Varchar,feed Varchar);");
        cat = new String[]{"5", "4", "3", "2", "1", };
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cat);
        sp.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    feed=Feed.getText().toString();
                ratings=sp.getSelectedItem().toString();
                 db.execSQL("insert into Feed values('"+ratings+"','"+feed+"');");

                    Toast.makeText(admin.this, "Feed Successfully Uploaded",Toast.LENGTH_SHORT ).show();


            }
        });
        new_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Feed.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin= new Intent(admin.this,MainActivity.class);
                admin.putExtra("key","abc");
                startActivity(admin);


            }
        });
    }
}