package com.example.a3in1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class Edit extends AppCompatActivity {


    Button mSaveBtn,mListBtn;
    EditText mTitleEt, mAmount, mDesc;

    ProgressDialog pd;
    FirebaseFirestore db;
    String  pTitle,pAmount,pDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        ActionBar actionBar = getSupportActionBar();
        mTitleEt = findViewById(R.id.titleEt);
        mAmount = findViewById(R.id.amountEt);
        mDesc = findViewById(R.id.descEt);
        mSaveBtn = findViewById(R.id.saveBtn);
        mListBtn = findViewById(R.id.backBtn);
        final Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            actionBar.setTitle("Edit Data");
            pTitle = bundle.getString("pTitle");
            pAmount = bundle.getString("pAmount");
            pDesc = bundle.getString("pDesc");
            mTitleEt.setText(pTitle);
            mAmount.setText(pAmount);
            mDesc.setText(pDesc);
        }
        else{
            actionBar.setTitle("Edit Data");
            pTitle = bundle.getString("pTitle");
            pAmount = bundle.getString("pAmount");
            pDesc = bundle.getString("pDesc");
            mTitleEt.setText(pTitle);
            mAmount.setText(pAmount);
            mDesc.setText(pDesc);
        }
        pd = new ProgressDialog(this);
        db =FirebaseFirestore.getInstance();
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = getIntent().getExtras();
                if(bundle!=null){
                    String title = mTitleEt.getText().toString().trim();
                    String amount = mAmount.getText().toString().trim();
                    String desc = mDesc.getText().toString().trim();
                    updateData(title,amount,desc);
                }
            }
        });

    }

    private void updateData(String title, String amount, String desc) {
        pd.setTitle("Updating Data");
        pd.show();
        db.collection("Stock").document(title)
                .update("id",title,"amount",amount,"takaran",desc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        pd.dismiss();
                        Toast.makeText(Edit.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(Edit.this, "Update Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}