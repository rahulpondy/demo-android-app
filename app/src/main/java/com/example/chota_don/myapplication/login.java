package com.example.chota_don.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.UiLifecycleHelper;

import java.util.Map;


public class login extends Activity {
    private String user_name;
    private String password;
    private EditText user_name_text;
    private EditText password_text;
    private Button ok_btn;
    private DatabaseConn dbObj;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ok_btn=(Button) findViewById(R.id.login);
        user_name_text=(EditText) findViewById(R.id.username);
        password_text=(EditText) findViewById(R.id.password);
        ok_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        user_name=user_name_text.getText().toString();
                        password=password_text.getText().toString();

                        if(check(user_name,password)){

                            Intent in_intent=new Intent(v.getContext(),login_facebook.class);
                            startActivity(in_intent);

                        }


                    }
                }
        );

    }

    public boolean check(String name,String password){
        dbObj=new DatabaseConn(this);
        String pass=dbObj.checkLogin(name);
       // System.out.print(pass);
        if(pass.equals(password)){
            return true;
        }
        else{
            return false;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
