package com.example.govimithuru;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity  {



    EditText mobile;
    Button button;
    String no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobile = (EditText) findViewById(R.id.mobile);

        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                no = mobile.getText().toString();
                validNo(no);
                Intent intent = new Intent(LoginActivity.this,VerufyPhoneActivity.class);
                intent.putExtra("mobile",no);
                startActivity(intent);
                Toast.makeText(LoginActivity.this,no,Toast.LENGTH_LONG).show();
            }
        });


    }

    private void validNo(String no){
        if(no.isEmpty() || no.length() < 12){
            mobile.setError("Enter a valid mobile");
            mobile.requestFocus();
            return;
        }
    }
}


