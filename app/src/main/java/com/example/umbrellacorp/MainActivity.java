package com.example.umbrellacorp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("info");
    String txtVision,txtHistory,txtAddress,longy,lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtVision = dataSnapshot.child("Vision").getValue().toString();
                txtHistory= dataSnapshot.child("history").getValue().toString();
                txtAddress = dataSnapshot.child("contadress").getValue().toString();
                longy = dataSnapshot.child("googlelink").getValue().toString();
                lang = dataSnapshot.child("googlelink2").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
     //getting all the data
    }
    public void GoAddressPage(View view){
        Intent intent = new Intent (this,addresslocation.class);
        intent.putExtra("txtAddress",txtAddress);
        intent.putExtra("longy",longy);
        intent.putExtra("langy",lang);
        startActivity(intent);

    }
    public void GoVisionPage(View view){
        Intent intent= new Intent(this,Vision.class);
        intent.putExtra("txtVision",txtVision);
        startActivity(intent);
    }
    public void GoHistoryPage(View view){
        Intent intent= new Intent(this,History.class);
        intent.putExtra("txtHistory",txtHistory);
        startActivity(intent);
    }
    public void GoSupportPage(View view){
        Intent intent = new Intent(this, Support.class);
        startActivity(intent);}
}
//passed parameters with intent for each page


