package com.example.a3in1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button login;
    Button anon;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        anon = findViewById(R.id.free);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null)
                {
                    Toast.makeText(MainActivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"User doesn't exist",Toast.LENGTH_SHORT).show();
                }
            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pwd = password.getText().toString();
                if(mail.isEmpty())
                {
                    email.setError("Please enter an Email address");
                    email.requestFocus();
                }
                else if(pwd.isEmpty())
                {
                    password.setError("Please enter a password");
                    password.requestFocus();
                }
                else if(mail.isEmpty()&&pwd.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else  if(!(mail.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(mail, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Login Error, Please Login Again",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent intToHome = new Intent(MainActivity.this,ListActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
            }
        });
        anon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intToHome = new Intent(MainActivity.this, CashierActivity.class);
                    startActivity(intToHome);
            }
        });
        };
}