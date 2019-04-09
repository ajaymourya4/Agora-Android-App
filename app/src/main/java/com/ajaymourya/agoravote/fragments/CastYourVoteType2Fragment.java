package com.ajaymourya.agoravote.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajaymourya.agoravote.R;

import androidx.fragment.app.Fragment;

public class CastYourVoteType2Fragment extends Fragment {


    public CastYourVoteType2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cast_your_vote_type2, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}
