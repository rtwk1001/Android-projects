  package com.example.lenovo.jokes;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

  public class MainActivity extends
          AppCompatActivity {
ListView lv;
      WebView wv;

boolean isloggedin=false;
    DrawerLayout drawerLayout;
   SQLiteDatabase db;
      int val;
      String email,password,username,age,category,cat;
    String[] array,feed;
    ArrayAdapter<String> adapter,adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        db = openOrCreateDatabase("jokedb ",MODE_PRIVATE,null);
        lv=(ListView)findViewById(R.id.side);

   array=new String[]{"Log In","Sign up","Insert Feed","-------------","View Content"};
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array);

        lv.setAdapter(adapter);

        lv.setSelector(android.R.color.holo_orange_light);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                         {
                                final Dialog dialog = new Dialog(MainActivity.this);
                                dialog.setTitle("Sign In");
                                dialog.setContentView(R.layout.login);
                                Button b1 = (Button) dialog.findViewById(R.id.b1);


                                final EditText e1 = (EditText) dialog.findViewById(R.id.et1);
                                final EditText e2 = (EditText) dialog.findViewById(R.id.et2);




                                b1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        final String emal = e1.getText().toString();
                                        final String pas = e2.getText().toString();


                                        Cursor c=db.rawQuery("select * from Users where email='"+emal+"' AND password='"+pas+"'",null);
                                        if (c.moveToNext())
                                        {
                                            email=c.getString(1);
                                             username=c.getString(0);
                                            password=c.getString(4);
                                             age=c.getString(2);

                                            Toast.makeText(MainActivity.this,"Hi  "+username+"\n your age is "+age,Toast.LENGTH_SHORT).show();
                                            Intent admin= new Intent(MainActivity.this,admin.class);
                                            admin.putExtra("key","abc");
                                            startActivity(admin);
                                            finish();
                                        }
                                        if(emal.equals(email)&&pas.equals(password)){
                                            dialog.cancel();
                                            Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
                                            isloggedin=true;
                                        }

                                    }
                                });

                                dialog.show();
                             drawerLayout.closeDrawers();
                            break;}

                    case 1:
                    {
                        final Dialog dialog1=new Dialog(MainActivity.this);
                        dialog1.setTitle("Register Yourself");
                        dialog1.setContentView(R.layout.signup);
                        final EditText fullname=(EditText)dialog1.findViewById(R.id.et3);
                        final EditText email=(EditText)dialog1.findViewById(R.id.et4);
                        final EditText et5=(EditText)dialog1.findViewById(R.id .et5);
                        final EditText phone=(EditText)dialog1.findViewById(R.id.et6);
                        final EditText set=(EditText)dialog1.findViewById(R.id.et7);
                        final EditText confirm=(EditText)dialog1.findViewById(R.id.et8);
                        Button register=(Button)dialog1.findViewById(R.id.b6);


                        db.execSQL("Create Table If Not Exists Users(fullName Varchar,email Varchar, teacherid Varchar,phone Varchar,password Varchar);");
                        register.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String name = fullname.getText().toString();
                                String address = email.getText().toString();
                                String teachersid = et5.getText().toString();
                                String ph=phone.getText().toString();
                                String pass1= set.getText().toString();
                                String pass2= confirm.getText().toString();

                                if (pass1.equals(pass2)){

                                    db.execSQL("insert into Users values('"+name+"','"+address+"','"+teachersid+"','"+ph+"','"+pass1+"'); ");

                                    Toast.makeText(MainActivity.this, "now sign-in with given user id and password",Toast.LENGTH_SHORT ).show();
                                    dialog1.cancel();

                                }
                                else confirm.setError("password does not matched");
                            }
                        });



                        dialog1.show();
                        drawerLayout.closeDrawers();
                    break;
                    }

                    case 2:{ category= new String("Insert Feed");


                            Intent display= new Intent(MainActivity.this,admin.class);
                            display.putExtra("key","abs");
                            startActivity(display);

                            Toast.makeText(MainActivity.this, "Please SignIn To Access the Content",Toast.LENGTH_SHORT ).show();
                        drawerLayout.closeDrawers();
                        break;

                    }
                    case 4:{ category= new String("View Content");

                        Cursor c1=db.rawQuery("select * From Feed  ",null);
                       val=c1.getCount();
                        feed= new String[val];
                         int i=0;
                        while (c1.moveToNext()) {

                            feed[i]  = c1.getString(1);
                           i++;}
                        Intent display= new Intent(MainActivity.this,Show.class);
                       display.putExtra("key",feed);
                        startActivity(display);

                            Toast.makeText(MainActivity.this, "Please SignIn To Access the Content",Toast.LENGTH_SHORT ).show();
                        drawerLayout.closeDrawers();
                        break;

                    }









                }

            }
        });

    }
}
