package com.example.batikadminmanagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userName, password1, passwordcom;
    private ProgressBar progressBar;
    private Button registerUser;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth  =  FirebaseAuth.getInstance();

        registerUser = findViewById(R.id.submit);
        registerUser.setOnClickListener(this);

        userName = findViewById(R.id.etUserName);
        password1 = findViewById(R.id.etPasswoord);
        passwordcom = findViewById(R.id.etPasswoordConform);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                registerUser();
                break;
        }
    }

    private void registerUser() {

        String email = userName.getText().toString().trim();
        String password = password1.getText().toString().trim();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(email, email);
                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(SignupActivity.this,"Sucessful add user", Toast.LENGTH_LONG).show();

                                    }                                   }
                            });
                        }
                    }
                });
    }



}