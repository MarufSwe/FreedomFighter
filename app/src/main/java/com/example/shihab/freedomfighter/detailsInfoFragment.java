package com.example.shihab.freedomfighter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class detailsInfoFragment extends Fragment {



    public detailsInfoFragment() {
        // Required empty public constructor
    }

    String  name;
    String  place_birth;
    String  work_edu;
    String  role_war;
    String award;
    int  image;
    String searchKey;


    ImageView personImg;
    TextView tvName,tvDetail,tvAward,tvEducation,tvVumika;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_details_info, container, false);

        name = getArguments().getString("name");
        place_birth = getArguments().getString("place_birth");
        work_edu = getArguments().getString("work_edu");
        role_war = getArguments().getString("role_war");
        award = getArguments().getString("award");
        image = getArguments().getInt("image");
       // searchKey = getArguments().getString("searchKey");


        tvName = (TextView) v.findViewById(R.id.textViewName);
        tvAward = (TextView) v.findViewById(R.id.textViewAward);
        tvDetail = (TextView) v.findViewById(R.id.textViewDetail);
        tvEducation = (TextView) v.findViewById(R.id.textViewEducation);
        tvVumika = (TextView) v.findViewById(R.id.textViewVumica);
        personImg = (ImageView) v.findViewById(R.id.imagePerson);


        personImg.setImageResource(image);
        tvName.setText(name);
        tvAward.setText(award);
        tvDetail.setText(place_birth);
        tvEducation.setText(work_edu);
        tvVumika.setText(role_war);


        return v;
    }



}
