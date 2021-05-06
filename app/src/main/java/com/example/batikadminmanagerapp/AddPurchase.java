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

public class AddPurchase extends AppCompatActivity {

    DBConnection BatikDB;
    Button saveDatabtn;
    ListView dataSet;
    EditText sales, type, qty,uprice, unitName;
    ArrayList<String> listitem;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase);


        BatikDB = new DBConnection(this);
        sales = findViewById(R.id.getPSale);
        type = findViewById(R.id.getPType);
        qty = findViewById(R.id.grtPQty);
        uprice = findViewById(R.id.getPUPrice);
        unitName = findViewById(R.id.getPUItem);



        saveDatabtn = findViewById(R.id.Create1);


        ADDPData();
    }

    public  void ADDPData(){
        saveDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sales  = sales.getText().toString();
                String Type  = type.getText().toString();
                String Qty  = qty.getText().toString();
                String Uprice = uprice.getText().toString();
                String ItemNAme = unitName.getText().toString();

                boolean insertData2 = BatikDB.addPurData(Sales, Type, Qty,Uprice, ItemNAme);

                if(insertData2 == true){
                    Toast.makeText(AddPurchase.this, "Data Added Correctly", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(AddPurchase.this, "Data Added Error", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}