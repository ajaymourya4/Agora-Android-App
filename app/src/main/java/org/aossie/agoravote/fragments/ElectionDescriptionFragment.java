package org.aossie.agoravote.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import org.aossie.agoravote.R;

import androidx.fragment.app.Fragment;

public class ElectionDescriptionFragment extends Fragment {


    public ElectionDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_election_description, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}
