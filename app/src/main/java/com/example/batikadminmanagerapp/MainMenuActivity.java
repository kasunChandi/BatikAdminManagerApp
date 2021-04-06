package com.example.batikadminmanagerapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView riceImage, breadImage, noodlesImage, foodImage;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu nenu;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Toolbar toolbar = findViewById(R.id.toolbarid);
        //  setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drowerLayout);
        navigationView=findViewById(R.id.mainnavigationview);
        //textView=findViewById(R.id.textView);
        toolbar=findViewById(R.id.toolbarid);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // navigationView.setNavigationItemSelectedListener(this);


        riceImage = findViewById(R.id.imageView);
        riceImage.setOnClickListener(this);
        breadImage = findViewById(R.id.imageView3);
        breadImage.setOnClickListener(this);
        noodlesImage = findViewById(R.id.imageView4);
        noodlesImage.setOnClickListener(this);
        foodImage = findViewById(R.id.imageView5);
        foodImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView :
                Toast.makeText(MainMenuActivity.this,"Food item 1", Toast.LENGTH_LONG).show();
              //  startActivity(new Intent(MainMenuActivity.this, QRcodeReader.class));
                break;
            case R.id.imageView3 :
                Toast.makeText(MainMenuActivity.this,"Food item 2", Toast.LENGTH_LONG).show();
                break;
            case R.id.imageView4 :
                Toast.makeText(MainMenuActivity.this,"Food item 3", Toast.LENGTH_LONG).show();
                break;
            case R.id.imageView5 :
                Toast.makeText(MainMenuActivity.this,"Food item 4", Toast.LENGTH_LONG).show();
                break;
        }
    }
}