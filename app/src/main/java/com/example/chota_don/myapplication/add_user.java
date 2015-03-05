package com.example.chota_don.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class add_user extends Activity {
    Button done;
    EditText name;
    EditText userName;
    EditText email;
    EditText password;

    private static Map<String,user_info> userDetailMap=new HashMap<String,user_info>();
    private static Set<String> userNameSet=new HashSet<String>();
    private DatabaseConn dbObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        dbObj=new DatabaseConn(this);
        done=(Button) findViewById(R.id.done);
        name=(EditText) findViewById(R.id.name);
        userName=(EditText) findViewById(R.id.user_name);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);

        done.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(checkUser(userName.getText().toString())){
                            dbObj.insert(userName.getText().toString(),name.getText().toString(),email.getText().toString(),password.getText().toString());
                            Intent in_intent=new Intent(v.getContext(),login_facebook.class);
                            startActivity(in_intent);
                        }
                        else{
//                            userDetailMap.put(userName.getText().toString(),new user_info(userName.getText().toString(),name.getText().toString(),password.getText().toString(),email.getText().toString()));
//                            Intent in_intent=new Intent(v.getContext(),login_facebook.class);
//                            in_intent.putExtra("msg","hiiii");
//                            startActivity(in_intent);
                        }
                    }
                }
        );
    }



    public static Map<String,user_info> returnMap(){
        return userDetailMap;
    }

    public boolean checkUser(String name){
        if(userNameSet.contains(name)){
            return false;
        }
        else{
            userNameSet.add(name);
            return true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_user, menu);
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
