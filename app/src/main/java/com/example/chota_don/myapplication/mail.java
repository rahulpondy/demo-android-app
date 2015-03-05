package com.example.chota_don.myapplication;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class mail extends Activity {
    EditText to,message,cc,subject;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        to=(EditText) findViewById(R.id.editText);
        subject=(EditText) findViewById(R.id.editText2);
        message=(EditText) findViewById(R.id.editText3);
        cc=(EditText) findViewById(R.id.editText4);
        send=(Button)findViewById(R.id.button2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmail();
            }
        });
    }
    public void sendmail(){

        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        String[] too={to.getText().toString()};
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,too);
        emailIntent.putExtra(Intent.EXTRA_CC,cc.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
        try{
            startActivity(emailIntent.createChooser(emailIntent,"send......"));
            finish();
            Log.i("Finished sending mail....","");

        }
        catch (ActivityNotFoundException e){
            Toast.makeText(mail.this,"there is no client",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mail, menu);
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
