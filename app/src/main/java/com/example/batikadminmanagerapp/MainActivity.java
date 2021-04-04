package com.example.batikadminmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(){

            public void run(){
                try {

                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                  //  Intent newIntent = new Intent(MainActivity.this, HomeActivity.class);
                   // startActivity(newIntent);
                    startActivity( new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }

        };
        thread.start();
    }
}