package com.example.batikadminmanagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView uregister;
    EditText etUsername, etPassword;
    Button btSubmit;

  FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uregister = findViewById(R.id.register);
        uregister.setOnClickListener(this);
        etUsername =findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPasswoord);
        btSubmit = findViewById(R.id.loginuser);
        btSubmit.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.register:
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.loginuser:
                userLogin();
                break;

        }
    }
    private void userLogin() {
        String email = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //Toast.makeText(MainActivity.this,"Login sucessful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainMenuActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this,"login error", Toast.LENGTH_LONG).show();
                }
            }
        });
/*
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //Toast.makeText(MainActivity.this,"Login sucessful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Mainmenu.class));
                }else{
                    Toast.makeText(MainActivity.this,"login error", Toast.LENGTH_LONG).show();
                }
            }
        });*/

    }


}