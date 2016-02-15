package com.cecs492a_group4.firebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by root on 2/13/16.
 */
public class Register extends Activity {

    Firebase mRef;
    String DB_URL =  "https://incandescent-heat-931.firebaseio.com/";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Firebase.setAndroidContext(this);

        mRef = new Firebase(DB_URL);
    }


    public void onClickButton(View v){
        if (v.getId() == R.id.BbackToLogin){
            Intent i = new Intent(Register.this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
        if (v.getId() == R.id.BTcreateAccount){
            EditText email =  (EditText) findViewById(R.id.TFemailRegister);
            String emailString = email.getText().toString();
            EditText password = (EditText) findViewById(R.id.TFpasswordRegister);
            String passwordString = password.getText().toString();
            //I stopped here after getting the user information by the username I need to know how to send them to the DB
            //from this activity.


            mRef.createUser(emailString, passwordString, new Firebase.ValueResultHandler<Map<String, Object>>() {
                @Override
                public void onSuccess(Map<String, Object> result) {
                    Log.d("Result","Successfully created user account with uid: " + result.get("uid"));

                    Intent ii = new Intent(Register.this,MainActivity.class);
                    startActivity(ii);
                }
                @Override
                public void onError(FirebaseError firebaseError) {
                    System.out.println("Failed to created user account with uid: ");
                }
            });



        }
    }


}
