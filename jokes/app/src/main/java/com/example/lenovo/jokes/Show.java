package com.example.lenovo.jokes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lenovo on 08-06-2016.
 */
public class Show extends Activity {
    ListView show;
    String[] array;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        show=(ListView)findViewById(R.id.show);
        Intent sho= getIntent();
       array= sho.getStringArrayExtra("key");




        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        show.setAdapter(adapter);

    }
}

