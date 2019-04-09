package org.aossie.agoravote.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import org.aossie.agoravote.R;

import androidx.fragment.app.Fragment;

public class VotingElectionDetailsFragment extends Fragment {


    public VotingElectionDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_voting_election_details, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}
