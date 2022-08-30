package com.example.fitwithit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void clickJoin(View view)
    {
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);  //za svaku od ovih po jedan activity pa onda idu login i register na isti activity gdej imas dole meni za
        // profil, hamster roll , daily quotes a gore da scrollas workouts mealplans fitness inspo calorie calculator(tu implementiras na activityu odatle web stranicu da otvara), a iz ostalih mozes slike da otvara ili dodavati sama

    }
    public void clickLogin(View view)
    {
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);

    }
    public void onRegister(View view)
    {
        Intent intent=new Intent(this, Registration.class);
        startActivity(intent);
    }
}