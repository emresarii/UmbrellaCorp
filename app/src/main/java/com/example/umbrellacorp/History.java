package com.example.umbrellacorp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class History extends AppCompatActivity {

    TextView textHistory;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        textHistory = (TextView) findViewById(R.id.textHistory);
        String txtHistory= getIntent().getStringExtra("txtHistory");
        textHistory.setText(txtHistory);


    }
}