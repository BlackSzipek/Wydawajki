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

import com.example.molly.wydawajki2.db.ClothesTable;
import com.example.molly.wydawajki2.db.DBHelper;
import com.example.molly.wydawajki2.db.FoodTable;
import com.example.molly.wydawajki2.db.HouseTable;
import com.example.molly.wydawajki2.db.RecreationTable;
import com.example.molly.wydawajki2.db.TripTable;
import com.example.molly.wydawajki2.db.UsersTable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddExpense1 extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener{
    String item;
    String formattedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense1);
        DBHelper dbHelper;
        UsersTable usersTable = new UsersTable(getApplicationContext());
        usersTable.openDB();
        Bundle bundle = getIntent().getExtras();
        final String cname = bundle.getString("cname");
        final Integer id = usersTable.getIdOfUser(cname);

        final EditText editText1 = (EditText)findViewById(R.id.editText2);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        List<String> categories = new ArrayList<String>();
        categories.add("Wydatki domowe");
        categories.add("Jedzenie");
        categories.add("Rozrywka");
        categories.add("Odzież");
        categories.add("Podróże");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(c);

        Button save = (Button)findViewById(R.id.save_expense);
        //Toast.makeText(editText1.getContext(), " " + id.toString(), Toast.LENGTH_LONG).show();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Double number = Double.parseDouble(editText1.getText().toString());
                if(item=="Wydatki domowe")
                {
                    HouseTable houseTable = new HouseTable(getApplicationContext());
                    houseTable.openDB();
                    houseTable.insertRecord(id,number,formattedDate);
                    Cursor cursor = houseTable.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    Toast.makeText(editText1.getContext(), "Zapisano!", Toast.LENGTH_SHORT).show();
                    houseTable.closeDB();
                    editText1.getText().clear();
                }
                if(item=="Jedzenie")
                {
                    FoodTable foodTable = new FoodTable(getApplicationContext());
                    foodTable.openDB();
                    foodTable.insertRecord(id,number,formattedDate);
                    Cursor cursor = foodTable.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    Toast.makeText(editText1.getContext(), "Zapisano!",Toast.LENGTH_SHORT).show();
                    foodTable.closeDB();
                    editText1.getText().clear();
                }
                if(item=="Rozrywka")
                {
                    RecreationTable recreationTable = new RecreationTable(getApplicationContext());
                    recreationTable.openDB();
                    recreationTable.insertRecord(id,number,formattedDate);
                    Cursor cursor = recreationTable.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    Toast.makeText(editText1.getContext(), "Zapisano!", Toast.LENGTH_SHORT).show();
                    recreationTable.closeDB();
                    editText1.getText().clear();

                }
                if(item=="Odzież")
                {
                    ClothesTable clothesTable = new ClothesTable(getApplicationContext());
                    clothesTable.openDB();
                    clothesTable.insertRecord(id,number,formattedDate);
                    Cursor cursor = clothesTable.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    Toast.makeText(editText1.getContext(), "Zapisano!", Toast.LENGTH_SHORT).show();
                    clothesTable.closeDB();
                    editText1.getText().clear();

                }
                if(item=="Podróże")
                {
                    TripTable tripTable  =new TripTable(getApplicationContext());
                    tripTable.openDB();
                    tripTable.insertRecord(id,number,formattedDate);
                    Cursor cursor = tripTable.getAllRecords();
                    cursor.moveToLast();
                    String drowid = cursor.getString(0);
                    String duserid = cursor.getString(1);
                    String dusersum = cursor.getString(2);
                    String ddate = cursor.getString(3);
                    Toast.makeText(editText1.getContext(), "Zapisano!", Toast.LENGTH_SHORT).show();
                    tripTable.closeDB();
                    editText1.getText().clear();
                }
                else
                {
                    //Toast.makeText(editText1.getContext(), "Nie wybrano żadnej kategorii", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        item = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), "Wybrano: " + item, Toast.LENGTH_LONG).show();
        // Showing selected spinner item
//            Toast.makeText(parent.getContext(), QuantityID, Toast.LENGTH_LONG)
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
    //
    }


}
