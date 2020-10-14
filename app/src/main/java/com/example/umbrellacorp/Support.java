package com.example.umbrellacorp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Support extends AppCompatActivity {
    Button buttonSend;
    EditText textName,textEmail,textPhone,textMessage;
    FirebaseDatabase db;
    DatabaseReference dbRef;
    String realname,realmail,realphone,realmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        buttonSend= (Button)findViewById(R.id.buttonSend);
        textEmail= (EditText) findViewById(R.id.textEmail);
        textPhone= (EditText) findViewById(R.id.textPhone);
        textName= (EditText) findViewById(R.id.textName);
        textMessage= (EditText) findViewById(R.id.textMessage);
        db= FirebaseDatabase.getInstance();
        dbRef=db.getReference("/visitors");
    }

    public void send(View view){
        realname = textName.getText().toString();
        realmail= textEmail.getText().toString();
        realphone= textPhone.getText().toString();
        realmessage= textMessage.getText().toString();
        CharSequence target = realmail;
        String phone=realphone;
        Boolean emailcheck= isValidEmail(target);
        Boolean phonecheck= isValidMobile(phone);
        if(realname.matches("")||realmail.matches("")||realphone.matches("")||realmessage.matches("")){ //empty check
            Toast.makeText(getApplicationContext(), "Please fill all of the form", Toast.LENGTH_LONG).show();
        }
        else if(emailcheck==false||phonecheck==false){//mail and phone check
            Toast.makeText(getApplicationContext(), "Invalid Email or Phone Number", Toast.LENGTH_LONG).show();
        }
        else {
            dbRef.push().setValue(new Visitors(realname, realmail, realphone, realmessage)); //writing as object
            Toast.makeText(getApplicationContext(), "Thank You For Your Message..", Toast.LENGTH_LONG).show();
            finish(); //database writing
        }

    }
   public final static boolean isValidEmail(CharSequence target) { //for email validation
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    private boolean isValidMobile(String phone) { //for phone validation
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
}
