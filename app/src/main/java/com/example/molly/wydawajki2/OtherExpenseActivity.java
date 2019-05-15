package com.example.molly.wydawajki2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.molly.wydawajki2.db.ExpensesClass;

import com.example.molly.wydawajki2.db.UsersTable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OtherExpenseActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
UsersTable usersTable;
String formattedDate;
String item;
String item2;
String item3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_expense);
        usersTable = new UsersTable(getApplicationContext());
        usersTable.openDB();
        Bundle bundle = getIntent().getExtras();
        final String cname = bundle.getString("cname");
        final Integer id = usersTable.getIdOfUser(cname);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(c);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner3) ;
        Spinner spinner2  = (Spinner)findViewById(R.id.spinner4);
        final EditText editText = (EditText)findViewById(R.id.editText3);

        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);

        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);
        List<String> categories = new ArrayList<String>();
        List<String> userscat = new ArrayList<String>();
        categories.add("Wydatki domowe");
        categories.add("Jedzenie");
        categories.add("Rozrywka");
        categories.add("Odzież");
        categories.add("Podróże");
        Cursor cursor = usersTable.getNames();
        cursor.moveToFirst();
        do {
            userscat.add(cursor.getString(0));
        }
        while(cursor.moveToNext());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, userscat);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter2);


        Button save3 = (Button)findViewById(R.id.button5);
        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Double number = Double.parseDouble(editText.getText().toString());
                //Toast.makeText(editText.getContext(), item3 , Toast.LENGTH_LONG).show();
                if(item3=="Wydatki domowe")
                {
                    ExpensesClass expensesClass = new ExpensesClass(getApplicationContext());
                    expensesClass.openDB();
                    expensesClass.insertRecord(id,item3,number,formattedDate,item2);
                    Cursor cursor = expensesClass.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    String dname = cursor.getString(4);
                    expensesClass.closeDB();
                    Toast.makeText(editText.getContext(), "Zapisano!", Toast.LENGTH_SHORT).show();
                    editText.getText().clear();
                }
                if(item3=="Jedzenie")
                {
                    ExpensesClass expensesClass = new ExpensesClass(getApplicationContext());
                    expensesClass.openDB();
                    expensesClass.insertRecord(id,item3,number,formattedDate,item2);
                    Cursor cursor = expensesClass.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    String dname = cursor.getString(4);
                    expensesClass.closeDB();
                    Toast.makeText(editText.getContext(), "Zapisano!", Toast.LENGTH_SHORT).show();
                    editText.getText().clear();
                }
                if(item3=="Rozrywka")
                {
                    ExpensesClass expensesClass = new ExpensesClass(getApplicationContext());
                    expensesClass.openDB();
                    expensesClass.insertRecord(id,item3,number,formattedDate,item2);
                    Cursor cursor = expensesClass.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    String dname = cursor.getString(4);
                    expensesClass.closeDB();
                    Toast.makeText(editText.getContext(), "Zapisano!", Toast.LENGTH_SHORT).show();
                    editText.getText().clear();

                }
                if(item3=="Odzież")
                {
                    ExpensesClass expensesClass = new ExpensesClass(getApplicationContext());
                    expensesClass.openDB();
                    expensesClass.insertRecord(id,item3,number,formattedDate,item2);
                    Cursor cursor = expensesClass.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    String dname = cursor.getString(4);
                    expensesClass.closeDB();
                    Toast.makeText(editText.getContext(), "Zapisano!", Toast.LENGTH_SHORT).show();
                    editText.getText().clear();

                }
                if(item3=="Podróże")
                {
                    ExpensesClass expensesClass = new ExpensesClass(getApplicationContext());
                    expensesClass.openDB();
                    expensesClass.insertRecord(id,item3,number,formattedDate,item2);
                    Cursor cursor = expensesClass.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    String dname = cursor.getString(4);
                    expensesClass.closeDB();
                    Toast.makeText(editText.getContext(), "Zapisano!", Toast.LENGTH_SHORT).show();
                    editText.getText().clear();
                }
                else
                {

                }

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        item = parent.getItemAtPosition(position).toString();
        if(item=="Jedzenie" || item=="Rozrywka" || item=="Podróże" || item=="Odzież" || item=="Wydatki domowe")
        {
            item3=item;
        }
        else
        {
            item2=item;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
