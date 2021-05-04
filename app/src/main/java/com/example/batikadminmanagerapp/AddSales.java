package com.example.batikadminmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddSales extends AppCompatActivity {


    //sales type qty

    DBConnection BatikDB;
    Button saveDatabtn;
    ListView dataSet;
    EditText sales, type, qty,uprice;
    ArrayList<String> listitem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sales);

        BatikDB = new DBConnection(this);
        sales = findViewById(R.id.getSale);
        type = findViewById(R.id.getType);
        qty = findViewById(R.id.grtQty);
         uprice = findViewById(R.id.getUPrice);



        saveDatabtn = findViewById(R.id.Create);


        ADDData();


    }

    public  void ADDData(){
        saveDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sales  = sales.getText().toString();
                String Type  = type.getText().toString();
                String Qty  = qty.getText().toString();
                String Uprice = uprice.getText().toString();

                boolean insertData = BatikDB.addData(Sales, Type, Qty,Uprice);

                if(insertData == true){
                    Toast.makeText(AddSales.this, "Data Added Correctly", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(AddSales.this, "Data Added Error", Toast.LENGTH_LONG).show();
                }


            }
        });
    }


}