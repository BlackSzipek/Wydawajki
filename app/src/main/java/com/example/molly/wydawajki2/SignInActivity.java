package com.example.molly.wydawajki2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.molly.wydawajki2.db.UsersTable;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        final EditText editText3 = (EditText)findViewById(R.id.editText5);
        final EditText editText4 = (EditText)findViewById(R.id.editText6);
        Button save = (Button)findViewById(R.id.button3);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cname = editText3.getText().toString();
                String cpass = editText4.getText().toString();

                UsersTable usersTable = new UsersTable(getApplicationContext());
                usersTable.openDB();
                if(usersTable.insertRecord(cname,cpass)==3)
                {
                    Toast.makeText(getApplicationContext(),"Nie ma takiej osoby w bazie - konto zostało założone!",Toast.LENGTH_SHORT).show();
                }
                if(usersTable.insertRecord(cname,cpass)==1)
                {
                    Toast.makeText(getApplicationContext(),"Użytkownik jest juz w bazie, a podane hasło jest dobre!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this, Account1Activity.class);
                    intent.putExtra("cname", cname);
                    startActivity(intent);
                }
                if(usersTable.insertRecord(cname,cpass)==2)
                {
                    Toast.makeText(getApplicationContext(),"Podane hasło jest złe!  Sprobuj jeszcze raz!",Toast.LENGTH_SHORT).show();
                }
                Cursor cursor = usersTable.getAllRecords();
                cursor.moveToLast();
                String crowid = cursor.getString(0);
                String cname1 = cursor.getString(1);
                String cpass1 = cursor.getString(2);
                usersTable.closeDB();
                finish();
            }
        });


    }
}
