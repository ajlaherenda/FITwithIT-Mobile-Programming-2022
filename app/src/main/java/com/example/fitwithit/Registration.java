package com.example.fitwithit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Registration extends AppCompatActivity {
    public EditText nameA, emailA, passwordA, dateA;
    public static final String EXTRA_EMAIL="",EXTRA_PASSWORD="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void onSignUp(View view)
    {   nameA=findViewById(R.id.nameA);
        emailA=findViewById(R.id.emailA);
        passwordA=findViewById(R.id.passwordA);
        dateA=findViewById(R.id.dateA);


        User userTest=UserDatabase.getInstance(this).userDao().getUserWithEmail(emailA.getText().toString());
        if(userTest == null)
        {
            User user=new User(nameA.getText().toString(), emailA.getText().toString(), passwordA.getText().toString(), dateA.getText().toString());
            UserDatabase.getInstance(this).userDao().add(user);
            Intent intent=new Intent(Registration.this, Login.class);
            intent.putExtra(EXTRA_EMAIL,emailA.getText().toString());
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Email address was already used by someone else.",Toast.LENGTH_LONG).show();
        }




    }

    public void onLoginAccount(View view)
    {
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
    }

}