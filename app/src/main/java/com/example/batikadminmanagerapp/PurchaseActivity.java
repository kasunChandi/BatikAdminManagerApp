package com.example.batikadminmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PurchaseActivity extends AppCompatActivity implements View.OnClickListener {
    Button backToMAnu,nextToMenu1 , viewAdd1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        backToMAnu = findViewById(R.id.btnOk);
        backToMAnu.setOnClickListener(this);

        nextToMenu1 = findViewById(R.id.btnAdd);
        nextToMenu1.setOnClickListener(this);

        viewAdd1 = findViewById(R.id.btnView);
        viewAdd1.setOnClickListener(this);

        BarChart barChart = findViewById(R.id.barChart) ;
        ArrayList<BarEntry> Visitors = new ArrayList<>();
        Visitors.add(new BarEntry(2014,45));
        Visitors.add(new BarEntry(2015,80));
        Visitors.add(new BarEntry(2016,50));
        Visitors.add(new BarEntry(2017,65));
        Visitors.add(new BarEntry(2018,60));

        BarDataSet barDataSet = new BarDataSet(Visitors, "Visiters");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.getDescription().setText("BarChartDemo");
        barChart.animateY(100);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOk :
                startActivity(new Intent(PurchaseActivity.this, MainMenuActivity.class));
                break;

            case R.id.btnAdd :
                startActivity(new Intent(PurchaseActivity.this, AddPurchase.class));
                break;

            case R.id.btnView :
                startActivity(new Intent(PurchaseActivity.this, viewData.class));
                break;
        }
    }
}