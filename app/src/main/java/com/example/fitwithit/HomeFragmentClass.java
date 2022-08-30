package com.example.fitwithit;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentClass extends Fragment {

    private String name;
    public HomeFragmentClass()
    {

    }
    public HomeFragmentClass(String nameString)
    {
        this.name=nameString;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.home_fragment_layout,container,false);

        TextView welcomeText;
        welcomeText=view.findViewById(R.id.hello);

        String message="Hello "+this.name;
        welcomeText.setText(message);


        ListView listView=(ListView) view.findViewById(R.id.list_view_container);

        HomepageItemAdapter homepageItemAdapter = new HomepageItemAdapter(getList(), getContext());

        listView.setAdapter(homepageItemAdapter);
        listView.setOnItemClickListener(onItemClickListener);


        return view;


    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            HomepageItem homepageItem = (HomepageItem) parent.getItemAtPosition(position);
            Intent intent = new Intent(getActivity(), HomepageItemDetails.class);

            if (homepageItem.getImageResID() == R.drawable.bmicalc) {
                openUrl();

            }
            else if (homepageItem.getImageResID() == R.drawable.workouts)
            {
                Toast.makeText(getContext(),"Enjoy endless workouts with our dear fitness influencer Maddie Lymburner", Toast.LENGTH_LONG).show();
                openWorkouts();
            }
            else {
               /* intent.putExtra(EXTRA_IMAGE, homepageItem.getImageResID());
                intent.putExtra(EXTRA_TITLE, homepageItem.getTitle());
                intent.putExtra(EXTRA_DESC, homepageItem.getDesc());  */

                startActivity(intent);
            }
        }
    };

    private List<HomepageItem> getList()
    { List<HomepageItem> itemList=new ArrayList<>();
        //slike i opisi
        itemList.add(new HomepageItem(R.drawable.mealplan,"MEAL PLANS", "Adjusted to various dietary lifestyles and updated regularly with inspirational recipes"));
        itemList.add(new HomepageItem(R.drawable.workouts,"WORKOUTS", "Upper, lower and full body workouts, which will bring you closer to your goal "));
        itemList.add(new HomepageItem(R.drawable.bmicalc, "BMI CALCULATOR","Calculate your body mass index in order to determine your level of fitness"));

        return itemList;

    }
    public void openUrl()
    {   String url="//www.calculator.net/bmi-calculator.html";

        Uri uriUrl=Uri.parse("https://"+url);

        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        try{
            startActivity(intent);
        }
        catch(ActivityNotFoundException e)
        {
            Toast.makeText(getActivity(),"Could not be executed",Toast.LENGTH_LONG).show();

        }

    }
    public void openWorkouts()
    {
        String url="//www.youtube.com/c/MadFit/playlists";
        Uri uriUrl=Uri.parse("https://"+url);

        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        try{
            startActivity(intent);
        }
        catch(ActivityNotFoundException e)
        {
            Toast.makeText(getActivity(),"Could not be executed",Toast.LENGTH_LONG).show();

        }

    }
}
