package com.example.a3in1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CashierActivity extends AppCompatActivity {

    Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier);
        check=findViewById(R.id.button);
        check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CashierActivity.this, Confirm.class);
                startActivity(i);
            }
        });
    }
}