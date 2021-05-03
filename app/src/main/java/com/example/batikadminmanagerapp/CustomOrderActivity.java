package com.example.batikadminmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class CustomOrderActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order);

        PieChart pieChart = findViewById(R.id.pichart);
        ArrayList<PieEntry>  visitors = new ArrayList<>();
        visitors.add(new PieEntry(50, "Complete"));
        visitors.add(new PieEntry(20, "Pending"));
        visitors.add(new PieEntry(30, "Not started"));

        PieDataSet pieDataSet = new PieDataSet(visitors, "custom order status" );
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(18f);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Custom Orders");
        pieChart.animate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOk :
                startActivity(new Intent(CustomOrderActivity.this, MainMenuActivity.class));
                break;
        }
    }
}