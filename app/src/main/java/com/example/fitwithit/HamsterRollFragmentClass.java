package com.example.fitwithit;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HamsterRollFragmentClass extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.hamster_roll_fragment_layout,container,false);


    }


    public void hamsterRollGame()
    {
        String url="//www.cbc.ca/kids/games/play/hamster-roll";
        Uri uriUrl=Uri.parse("https://"+url);

        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        try{
            Toast.makeText(getActivity(),"Play and win premium workout and meal plans!",Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        catch(ActivityNotFoundException e)
        {
            Toast.makeText(getActivity(),"Could not be executed",Toast.LENGTH_LONG).show();

        }
    }
}
