package com.cecs492a_group4.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.AuthData;


import java.util.Map;

public class MainActivity extends AppCompatActivity {


    Firebase mRef;
    public static final String DB_URL = "https://incandescent-heat-931.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Firebase.setAndroidContext(this);


        //mRef = new Firebase(DB_URL);



    }

    public void onButtonClick(View v){
        if (v.getId() == R.id.BTregister){
            Intent i = new Intent(this,Register.class);
            startActivity(i);
        }
        if (v.getId() == R.id.BLogin) {
            EditText e = (EditText) findViewById(R.id.TFemailLogin);
            String email = e.getText().toString();
            EditText p = (EditText) findViewById(R.id.TFloginPassword);
            String password = p.getText().toString();
            Log.d("email: ",email);
            Log.d("password: ",password);

        }
    }


}
