package com.example.molly.wydawajki2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.molly.wydawajki2.db.ClothesTable;
import com.example.molly.wydawajki2.db.ExpensesClass;
import com.example.molly.wydawajki2.db.FoodTable;
import com.example.molly.wydawajki2.db.RecreationTable;
import com.example.molly.wydawajki2.db.TripTable;
import com.example.molly.wydawajki2.db.UsersTable;

import java.util.ArrayList;
import java.util.List;

public class ShowOtherExpneses extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
    UsersTable usersTable;
    Cursor cursor;
    Cursor cursor3;
    ExpensesClass expensesClass;
    private ArrayAdapter<String> adapter ;
    private Integer iduser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_other_expneses);
        Bundle bundle = getIntent().getExtras();
        final String cname = bundle.getString("cname");
        Spinner spinner = (Spinner) findViewById(R.id.spinner6);
        expensesClass = new ExpensesClass(getApplicationContext());
        expensesClass.openDB();
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        usersTable = new UsersTable(getApplicationContext());
        usersTable.openDB();
        iduser = usersTable.getIdOfUser(cname);
        List<String> userscat = new ArrayList<String>();
        Cursor cursor = usersTable.getNames();
        cursor.moveToFirst();
        do {
            userscat.add(cursor.getString(0));
        }
        while(cursor.moveToNext());

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, userscat);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter2);
        Cursor cursor3=usersTable.getAllRecords();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String item = parent.getItemAtPosition(position).toString();
        {
            cursor = expensesClass.getUserOfName(iduser,item);
            if((cursor != null) && (cursor.getCount() > 0) && cursor!=cursor3)
            {
                cursor.moveToFirst();

                List<String> where = new ArrayList<String>();

                do
                {
                    where.add(cursor.getString(0)+",    "+cursor.getString(1)+",     "+cursor.getString(2)
                    +",      "+cursor.getString(3));
                }
                while (cursor.moveToNext());



                ListView listView = (ListView)findViewById(R.id.listview1);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
                listView.setAdapter(adapter);
                cursor3=cursor;
            }
            else
            {
                List<String> where = new ArrayList<String>();
                ListView listView = (ListView)findViewById(R.id.listview1);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.Row,where);
                listView.setAdapter(adapter);

            }
    }}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
