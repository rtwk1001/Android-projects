package com.example.lenovo.brtwk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.AbstractCollection;

/**
 * Created by Lenovo on 05-06-2016.
 */
public class Option extends Activity {
    ListView lv;
    ArrayAdapter<String> ad;
    String[] options={"User Profile","Change Theme", "About Brtwk","About rtwk","Customize your browser","Network setings","History"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        lv=(ListView)findViewById(R.id.listView);
        ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(Option.this, options[0]+"Soon will be updated",Toast.LENGTH_SHORT).show();
                    case 1:
                        Toast.makeText(Option.this,options[1]+" Soon will be updated",Toast.LENGTH_SHORT).show();
                    case 2:
                        Toast.makeText(Option.this,options[2]+" will update soon",Toast.LENGTH_SHORT).show();
                    case 3:
                        Toast.makeText(Option.this,options[3]+" will update soon",Toast.LENGTH_SHORT).show();
                    case 4:
                        Toast.makeText(Option.this,options[4]+" will update soon",Toast.LENGTH_SHORT).show();
                    case 5:
                        Toast.makeText(Option.this,options[5]+" will update soon",Toast.LENGTH_SHORT).show();
                    case 6:
                        Toast.makeText(Option.this,options[6]+" will update soon",Toast.LENGTH_SHORT).show();



                }

            }
        });
    }
}
