package com.example.fitwithit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomepageItemDetails extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_item_details);

        /*

        imageView = findViewById(R.id.image);
        title = findViewById(R.id.titleD);
        description = findViewById(R.id.descD); */
/*
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
          //  setTitle(extras.getString(Homepage.EXTRA_TITLE));
            imageView.setImageResource(extras.getInt(Homepage.EXTRA_IMAGE));
            title.setText(extras.getString(Homepage.EXTRA_TITLE));
            description.setText(extras.getString(Homepage.EXTRA_DESC));
        } */
    }

    public void download(View view)
    {
        String url="//www.maddielymburner.com/collections/ebooks";
        Uri uriUrl=Uri.parse("https://"+url);

        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        try{
            startActivity(intent);
        }
        catch(ActivityNotFoundException e)
        {
            Toast.makeText(this,"Could not be executed",Toast.LENGTH_LONG).show();

        }
    }
}