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

public class TotalSalesActivity extends AppCompatActivity implements View.OnClickListener{

    Button backToMAnu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_sales);

        backToMAnu = findViewById(R.id.btnOk);
        backToMAnu.setOnClickListener(this);

        BarChart barChart = findViewById(R.id.barChart) ;
        ArrayList<BarEntry> Visitors = new ArrayList<>();
        Visitors.add(new BarEntry(2014,450));
        Visitors.add(new BarEntry(2015,850));
        Visitors.add(new BarEntry(2016,450));
        Visitors.add(new BarEntry(2017,550));
        Visitors.add(new BarEntry(2018,650));

        BarDataSet barDataSet = new BarDataSet(Visitors, "Visiters");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.getDescription().setText("BarChartDemo");
        barChart.animateY(1000);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOk :
                startActivity(new Intent(TotalSalesActivity.this, MainMenuActivity.class));
                break;
        }

    }
}