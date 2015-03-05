package com.example.chota_don.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;


public class login_facebook extends Activity{
    Button bttn;
    private View otherview;
    private UiLifecycleHelper lifecycleHelper;
    final String tag="login_facebook";
    private Session.StatusCallback callback=new Session.StatusCallback(){
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            final TextView nameV=(TextView) findViewById(R.id.name);
            final TextView genderV=(TextView) findViewById(R.id.gender);
            final TextView locationV=(TextView) findViewById(R.id.location);
            if(state.isOpened()){
                Log.i(tag,"log in");
                    Request.newMeRequest(session,new Request.GraphUserCallback() {
                        @Override
                        public void onCompleted(GraphUser user, Response response) {

                            if(user!=null){
                                otherview.setVisibility(View.VISIBLE);

                                nameV.setText(user.getName());
                                genderV.setText(user.getProperty("gender").toString());
                                locationV.setText(user.getLocation().toString());
                               // Intent in=new Intent(getApplicationContext(),Facebook_detail.class);
                                //startActivity(in);

                            }
                        }
                    }).executeAsync();
                }else if(state.isClosed()){
                Log.i(tag,"log out");
                otherview.setVisibility(View.GONE);

                }
        }
        };




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_facebook);
        bttn=(Button) findViewById(R.id.button);
        bttn.setOnClickListener(onClickListener);
        otherview=findViewById(R.id.otherView);
        otherview.setVisibility(View.GONE);
        lifecycleHelper=new UiLifecycleHelper(this, callback);
        lifecycleHelper.onCreate(savedInstanceState);

    }
    View.OnClickListener onClickListener=new View.OnClickListener(){
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                Intent in_intent=new Intent(v.getContext(),mail.class);
                startActivity(in_intent);
                break;
        }
    }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleHelper.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleHelper.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycleHelper.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lifecycleHelper.onActivityResult(requestCode,resultCode,data);
        Log.i(tag,"OnActivityResult");
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_login_facebook, menu);
//        return true;
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lifecycleHelper.onSaveInstanceState(outState);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
