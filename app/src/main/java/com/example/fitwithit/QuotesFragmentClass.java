package com.example.fitwithit;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuotesFragmentClass extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        List<String> quotes=new ArrayList<>();
        quotes.add("The only person you are destined to become is the person you decide to be. – Ralph Waldo Emerson");
        quotes.add("Once you learn to quit, it becomes a habit. ― Vince Lombardi Jr");
        quotes.add("A year from now you may wish you had started today. – Karen Lamb");
        quotes.add("Our growing softness, our increasing lack of physical fitness, is a menace to our security.— John F. Kennedy");
        quotes.add("Most people fail, not because of lack of desire, but, because of lack of commitment. – Vince Lombardi");
        quotes.add("Some people want it to happen, some wish it would happen, others make it happen. – Michael Jordan");
        String quote=quoteGenerator(quotes);
        View view=inflater.inflate(R.layout.quotes_fragment_layout,container,false);
        TextView output=view.findViewById(R.id.izreka);
        output.setText(quote);


        return view;
    }

    public String quoteGenerator(List<String> quotes)
    {       int size=quotes.size();
            Random random = new Random();
            int randomNumber = random.nextInt(size) + 0;

            return quotes.get(randomNumber);
    }
}
