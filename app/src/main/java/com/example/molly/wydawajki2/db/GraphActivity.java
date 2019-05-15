package com.example.molly.wydawajki2.db;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.molly.wydawajki2.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class GraphActivity extends AppCompatActivity {
    Float float1;
    Float float2;
    Float float3;
    Float float4;
    Float float5;
    HouseTable houseTable;
    UsersTable usersTable;
    FoodTable foodTable;
    RecreationTable recreationTable;
    ClothesTable clothesTable;
    TripTable tripTable;
    Cursor cursor;
    Cursor cursor2;
    Cursor cursor3;
    Cursor cursor4;
    Cursor cursor5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        usersTable = new UsersTable(getApplicationContext());
        usersTable.openDB();
        Bundle bundle = getIntent().getExtras();
        final String cname = bundle.getString("cname");
        final Integer id = usersTable.getIdOfUser(cname);
        //HOUSE TABLE
        houseTable = new HouseTable(getApplicationContext());
        houseTable.openDB();
        cursor = houseTable.getSumOfExpenses(id);
        cursor.moveToFirst();
        if((cursor != null) && (cursor.getCount() > 0) && cursor.getString(0)!=null)
        {
        float1 = Float.parseFloat(cursor.getString(0));}
        else
        {
          float1=0f;
        }
        //food table
        foodTable = new FoodTable(getApplicationContext());
        foodTable.openDB();
        cursor2 = foodTable.getSumOfExpenses(id);
        cursor2.moveToFirst();
        if((cursor2 != null) && (cursor2.getCount() > 0) && cursor2.getString(0)!=null)
        {

            float2 = Float.parseFloat(cursor2.getString(0));}
        else
        {
            float2=0f;
        }
        //recreation table
        recreationTable = new RecreationTable(getApplicationContext());
        recreationTable.openDB();
        cursor3 = recreationTable.getSumOfExpenses(id);
        cursor3.moveToFirst();
        if((cursor3 != null) && (cursor3.getCount() > 0) && cursor3.getString(0)!=null)
        {

            float3 = Float.parseFloat(cursor3.getString(0));}
        else
        {
            float3=0f;
        }
        //clothes table
        clothesTable = new ClothesTable(getApplicationContext());
        clothesTable.openDB();
        cursor4 = clothesTable.getSumOfExpenses(id);
        cursor4.moveToFirst();
        if((cursor4 != null) && (cursor4.getCount() > 0) && cursor4.getString(0)!=null)
        {
            cursor4.moveToFirst();
            float4 = Float.parseFloat(cursor4.getString(0));}
        else
        {
            float4=0f;
        }
        //trip table
        tripTable = new TripTable(getApplicationContext());
        tripTable.openDB();
        cursor5 = tripTable.getSumOfExpenses(id);
        cursor5.moveToFirst();
        if((cursor5 != null) && (cursor5.getCount() > 0) && cursor5.getString(0)!=null)
        {
            cursor5.moveToFirst();
            float5 = Float.parseFloat(cursor5.getString(0));}
        else
        {
            float5=0f;
        }


        BarChart chart = (BarChart) findViewById(R.id.chart);
        ArrayList<BarEntry> BarEntry = new ArrayList<>();

        BarEntry.add(new BarEntry(float1, 0));
        BarEntry.add(new BarEntry(float2, 1));
        BarEntry.add(new BarEntry(float3, 2));
        BarEntry.add(new BarEntry(float4, 3));
        BarEntry.add(new BarEntry(float5, 4));

        BarDataSet dataSet = new BarDataSet(BarEntry, "Kategorie wydawajków");

        ArrayList<String> labels = new ArrayList<>();
        labels.add("Wydatki domowe");
        labels.add("Jedzenie");
        labels.add("Rozrywka");
        labels.add("Odzież");
        labels.add("Podróże");

        BarData data = new BarData(labels, dataSet);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
        chart.setDescription("Wydawajki");



    }
}
