package com.ajaymourya.agoravote.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajaymourya.agoravote.R;

import androidx.fragment.app.Fragment;

public class VotingAlgorithmFragment extends Fragment {


    public VotingAlgorithmFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_voting_algorithm, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}
