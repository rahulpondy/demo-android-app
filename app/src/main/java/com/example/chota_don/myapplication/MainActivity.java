package com.example.chota_don.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.up);
        b2=(Button) findViewById(R.id.in);
        b1.setOnClickListener(handler);
        b2.setOnClickListener(handler);
    }

    View.OnClickListener handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.up:
                    Intent up_intent=new Intent(v.getContext(),login.class);
                    up_intent.putExtra("msg","hiiii");
                    startActivity(up_intent);
                   break;
                case R.id.in:
                    Intent in_intent=new Intent(v.getContext(),add_user.class);
                    in_intent.putExtra("msg","hiiii");
                    startActivity(in_intent);
                    break;
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
