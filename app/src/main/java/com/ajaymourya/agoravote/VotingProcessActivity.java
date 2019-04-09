package com.ajaymourya.agoravote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ajaymourya.agoravote.fragments.AddCandidateFragment;
import com.ajaymourya.agoravote.fragments.CastYourVoteFragment;
import com.ajaymourya.agoravote.fragments.CastYourVoteType2Fragment;
import com.ajaymourya.agoravote.fragments.ElectionDescriptionFragment;
import com.ajaymourya.agoravote.fragments.ElectionPrivacyFragment;
import com.ajaymourya.agoravote.fragments.ElectionStartEndFragment;
import com.ajaymourya.agoravote.fragments.VotingAlgorithmFragment;
import com.ajaymourya.agoravote.fragments.VotingElectionDetailsFragment;
import com.kofigyan.stateprogressbar.StateProgressBar;
import com.kofigyan.stateprogressbar.components.StateItem;
import com.kofigyan.stateprogressbar.listeners.OnStateItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class VotingProcessActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ViewPager viewPager;

    private Button mCancelButton;

    private Button mVoteButton;

    String[] descriptionData = {"Election Details", "Cast your Vote"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_process);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Agora Vote");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.voting_horizontal_stepper);
        stateProgressBar.setStateDescriptionData(descriptionData);

        viewPager = (ViewPager) findViewById(R.id.voting_election_viewpager);
        setupViewPager(viewPager);

        mCancelButton = findViewById(R.id.voting_cancel);
        mVoteButton = findViewById(R.id.voting_vote);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                switch (position) {
                    case 0:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                        mCancelButton.setVisibility(View.INVISIBLE);
                        mVoteButton.setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        mCancelButton.setVisibility(View.VISIBLE);
                        mVoteButton.setVisibility(View.VISIBLE);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        stateProgressBar.setOnStateItemClickListener(new OnStateItemClickListener() {
            @Override
            public void onStateItemClick(StateProgressBar stateProgressBar, StateItem stateItem, int stateNumber, boolean isCurrentState) {
                viewPager.setCurrentItem(stateNumber-1);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        VotingProcessActivity.ViewPagerAdapter adapter = new VotingProcessActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VotingElectionDetailsFragment());
        adapter.addFragment(new CastYourVoteFragment());
        adapter.addFragment(new CastYourVoteType2Fragment());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
