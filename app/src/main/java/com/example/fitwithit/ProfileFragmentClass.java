package com.example.fitwithit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class ProfileFragmentClass extends Fragment {

    private String name;


    public ProfileFragmentClass()
    {

    }

    public ProfileFragmentClass(String passedName)
    {
        this.name=passedName;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.profile_fragment_layout,container,false);

        TextView fullName,email,birthday,weight,height;
        fullName=view.findViewById(R.id.imePrezime);
        email=view.findViewById(R.id.email);
        birthday=view.findViewById(R.id.rodendan);
        weight=view.findViewById(R.id.tezina);
        height=view.findViewById(R.id.visina);

        User user=UserDatabase.getInstance(getContext()).userDao().getUserWithFullName(this.name);

        fullName.setText(this.name);
        email.setText(user.getEmail());
        birthday.setText(user.getDateOfBirth());
        weight.setText("Not entered");
        height.setText("Not entered");



        return view;
    }
}
