package com.encryptionapp.junaid.encryptionapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText Nametv,tvstichingfac1,tvdaysopen2 ,textview7;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reference = FirebaseDatabase.getInstance().getReference("users");

        Nametv=findViewById(R.id.tv1);
        tvstichingfac1=findViewById(R.id.tv4);
        tvdaysopen2=findViewById(R.id.tv6);
        textview7=findViewById(R.id.tv14);
        (findViewById(R.id.add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=Nametv.getText().toString();
                String tvstitchingfac=tvstichingfac1.getText().toString();
                String tvdaysopen =tvdaysopen2.getText().toString();
                String textview=textview7.getText().toString();
                String id = reference.push().getKey();
                reference.child(id).child("name").setValue(name);
                reference.child(id).child("facilities").setValue(tvstitchingfac);
                reference.child(id).child("DaysOpen").setValue(tvdaysopen);
                reference.child(id).child("contactNo").setValue(textview);
            }
        });

    }
}
