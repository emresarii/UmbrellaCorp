package com.example.umbrellacorp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addresslocation extends AppCompatActivity {
    TextView addresstext;
    String address;
    TextView clickableLang;
    String longy,lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresslocation);
        addresstext=(TextView)findViewById(R.id.addresstext);
        clickableLang=(TextView)findViewById(R.id.clickableLang);
        address=getIntent().getStringExtra("txtAddress");
        addresstext.setText(address);
        longy=getIntent().getStringExtra("longy");
        lang=getIntent().getStringExtra("langy");

        }
        public void goMaps(View view){ //googlemaps integration
            String label = "Umbrella Corp";
            String uriBegin = "geo:" + longy + "," + lang;
            String query = longy + "," + lang + "(" + label + ")";
            String encodedQuery = Uri.encode(query);
            String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
            Uri uri = Uri.parse(uriString);
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }

        }


