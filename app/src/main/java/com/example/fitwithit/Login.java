package com.example.fitwithit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    public EditText email, password;
    public static final String EXTRA_NAME="NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent=getIntent();

        email=findViewById(R.id.emailL);
        password=findViewById(R.id.passL);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String mail = extras.getString(Registration.EXTRA_EMAIL);
            User user=UserDatabase.getInstance(this).userDao().getUserWithEmail(mail);
            String pass=user.getPassword();

            email.setText(mail);
            password.setText(pass);
            }


    }

    public void clickOnLogin(View view)
    {
        email=findViewById(R.id.emailL);
        password=findViewById(R.id.passL);

        User user=UserDatabase.getInstance(this).userDao().getUserWithEmail(email.getText().toString());

        if(user != null)
        {
        if(user.getPassword().equals(password.getText().toString()))
        {
            String name=user.getNameSurname();
            Toast.makeText(getApplicationContext(),"Successful login",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this, Homepage.class);
            intent.putExtra(EXTRA_NAME,name);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Incorrect password", Toast.LENGTH_LONG).show();
        }
        }
        else{
            Toast.makeText(getApplicationContext(), "Incorrect email", Toast.LENGTH_LONG).show();

        }

    }
}