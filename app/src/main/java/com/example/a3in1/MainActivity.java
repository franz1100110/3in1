package com.example.a3in1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

lateinit var ref : DatabaseReference
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ref = FirebaseDatabase.getInstance().getReference("USERS")
        Object btnSave;
        btnSave.setOnClickListener {
            savedata()
        }
    }