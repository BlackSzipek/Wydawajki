package com.example.molly.wydawajki2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.molly.wydawajki2.db.ClothesTable;
import com.example.molly.wydawajki2.db.FoodTable;
import com.example.molly.wydawajki2.db.HouseTable;
import com.example.molly.wydawajki2.db.RecreationTable;
import com.example.molly.wydawajki2.db.TripTable;
import com.example.molly.wydawajki2.db.UsersTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowExpenses1 extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener
{
HouseTable houseTable;
UsersTable usersTable;
FoodTable foodTable;
RecreationTable recreationTable;
ClothesTable clothesTable;
TripTable tripTable;
Cursor cursor;
    private ArrayAdapter<String> adapter ;
    private Integer iduser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_expenses1);

        Bundle bundle = getIntent().getExtras();
        final String cname = bundle.getString("cname");
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        usersTable = new UsersTable(getApplicationContext());
        usersTable.openDB();
        iduser = usersTable.getIdOfUser(cname);

        houseTable = new HouseTable(getApplicationContext());
        houseTable.openDB();
        foodTable = new FoodTable(getApplicationContext());
        foodTable.openDB();
        recreationTable = new RecreationTable(getApplicationContext());
        recreationTable.openDB();
        clothesTable = new ClothesTable(getApplicationContext());
        clothesTable.openDB();
        tripTable  = new TripTable(getApplicationContext());
        tripTable.openDB();

        //spinner

        List<String> categories = new ArrayList<String>();
        categories.add("Wydatki domowe");
        categories.add("Jedzenie");
        categories.add("Rozrywka");
        categories.add("Odzież");
        categories.add("Podróże");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Wybrano: " + item, Toast.LENGTH_LONG).show();
        if(item=="Wydatki domowe")
        {
            cursor = houseTable.getSumAndDate(iduser);
            if((cursor != null) && (cursor.getCount() > 0))
            {
            cursor.moveToFirst();

            List<String> where = new ArrayList<String>();

            do
                {
                where.add(cursor.getString(0)+"                                                         "+cursor.getString(1));
                }
            while (cursor.moveToNext());



            ListView listView = (ListView)findViewById(R.id.listview);
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
            listView.setAdapter(adapter);
        }
        else
            {
                List<String> where = new ArrayList<String>();
                ListView listView = (ListView)findViewById(R.id.listview);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
                listView.setAdapter(adapter);

            }
        }
        if(item=="Jedzenie")
        {
            cursor =foodTable.getSumAndDate(iduser);
            if((cursor != null) && (cursor.getCount() > 0))
            {
            cursor.moveToFirst();

            List<String> where = new ArrayList<String>();

            do
            {
                where.add(cursor.getString(0)+"                                                         "+cursor.getString(1));
            }
            while (cursor.moveToNext());
            ListView listView = (ListView)findViewById(R.id.listview);
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
            listView.setAdapter(adapter);
        }
            else
            {
                List<String> where = new ArrayList<String>();
                ListView listView = (ListView)findViewById(R.id.listview);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
                listView.setAdapter(adapter);

            }}
        if(item=="Rozrywka")
        {
            cursor =recreationTable.getSumAndDate(iduser);
            if((cursor != null) && (cursor.getCount() > 0)){
            cursor.moveToFirst();

            List<String> where = new ArrayList<String>();

            do
            {
                where.add(cursor.getString(0)+"                                                         "+cursor.getString(1));
            }
            while (cursor.moveToNext());
            ListView listView = (ListView)findViewById(R.id.listview);
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
            listView.setAdapter(adapter);

        }
            else
            {
                List<String> where = new ArrayList<String>();
                ListView listView = (ListView)findViewById(R.id.listview);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
                listView.setAdapter(adapter);

            }}
        if(item=="Odzież")
        {

            cursor =clothesTable.getSumAndDate(iduser);
            if((cursor != null) && (cursor.getCount() > 0)) {
                cursor.moveToFirst();

                List<String> where = new ArrayList<String>();

                do {
                    where.add(cursor.getString(0) + "                                                         " + cursor.getString(1));
                }
                while (cursor.moveToNext());
                ListView listView = (ListView) findViewById(R.id.listview);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.Row, where);
                listView.setAdapter(adapter);
            }
            else
            {
                List<String> where = new ArrayList<String>();
                ListView listView = (ListView)findViewById(R.id.listview);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
                listView.setAdapter(adapter);

            }
        }
        if(item=="Podróże")
        {
            cursor =tripTable.getSumAndDate(iduser);
            if((cursor != null) && (cursor.getCount() > 0))
            {cursor.moveToFirst();

            List<String> where = new ArrayList<String>();

            do
            {
                where.add(cursor.getString(0)+"                                                         "+cursor.getString(1));
            }
            while (cursor.moveToNext());
            ListView listView = (ListView)findViewById(R.id.listview);
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
            listView.setAdapter(adapter);}
            else
            {
                List<String> where = new ArrayList<String>();
                ListView listView = (ListView)findViewById(R.id.listview);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
                listView.setAdapter(adapter);

            }
        }
        else
        {

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }



}

