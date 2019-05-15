package com.example.molly.wydawajki2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.molly.wydawajki2.db.GraphActivity;

public class Account1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account1);

        Bundle bundle = getIntent().getExtras();
        final String cname = bundle.getString("cname");
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText("Witaj użytkowniku  '"+cname+"'");

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fAB);
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fAB2);
        FloatingActionButton fab3 = (FloatingActionButton)findViewById(R.id.fAB3);
        FloatingActionButton fab4 = (FloatingActionButton)findViewById(R.id.fAB4);
        FloatingActionButton fab5 = (FloatingActionButton)findViewById(R.id.fAB5);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(Account1Activity.this, AddExpense1.class);
                intent1.putExtra("cname", cname);
                startActivity(intent1);

            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(Account1Activity.this, ShowExpenses1.class);
                intent2.putExtra("cname", cname);
                startActivity(intent2);
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(Account1Activity.this, GraphActivity.class);
                intent2.putExtra("cname", cname);
                startActivity(intent2);
            }
        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(Account1Activity.this, OtherExpenseActivity.class);
                intent2.putExtra("cname", cname);
                startActivity(intent2);
            }
        });

        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(Account1Activity.this, ShowOtherExpneses.class);
                intent2.putExtra("cname", cname);
                startActivity(intent2);
            }
        });
    }
}
