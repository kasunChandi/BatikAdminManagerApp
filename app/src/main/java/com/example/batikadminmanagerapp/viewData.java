package com.example.batikadminmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class viewData extends AppCompatActivity {

    private  static  final  String TAG = "viewData";
    DBConnection dbConnection2;
    private ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        mlistView = findViewById(R.id.listView);
        dbConnection2 = new DBConnection(this);

        populateListView();
    }

    private void  populateListView(){
        Log.d(TAG, "Populating Daya in tha List");
        Cursor data = dbConnection2.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mlistView.setAdapter(adapter);
    }
}