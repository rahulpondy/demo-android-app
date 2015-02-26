package com.example.chota_don.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;


public class login extends Activity {
    private String user_name;
    private String password;
    private EditText user_name_text;
    private EditText password_text;
    private Button ok_btn;


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
                        Map<String,user_info> get_map=add_user.returnMap();
                        if(get_map.containsKey(user_name)){
                            if(get_map.get(user_name).getPassword().equals(password)){
                                Intent in_intent=new Intent(v.getContext(),login_facebook.class);
                                in_intent.putExtra("msg","hiiii");
                                startActivity(in_intent);
                            }
                            else{
                                //password is wrong

                            }
                        }
                        else{
                            //doesn't contain key or key has been forgot

                        }


                    }
                }
        );

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
