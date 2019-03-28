package com.ajaymourya.agoravote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ajaymourya.agoravote.fragments.AddCandidateFragment;
import com.ajaymourya.agoravote.fragments.ElectionDescriptionFragment;
import com.ajaymourya.agoravote.fragments.ElectionPrivacyFragment;
import com.ajaymourya.agoravote.fragments.ElectionStartEndFragment;
import com.ajaymourya.agoravote.fragments.VotingAlgorithmFragment;

import java.util.ArrayList;
import java.util.List;

public class CreateElectionsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private Button mPreviousButton;
    private Button mNextButton;
    private TextView mStepCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_elections);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Create Election");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.create_election_viewpager);
        setupViewPager(viewPager);

        mPreviousButton = findViewById(R.id.previous);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(-1), true);
            }
        });

        mNextButton = findViewById(R.id.next);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(+1), true);

                if (mNextButton.getText().equals("Finish")) {
                    Intent intent = new Intent(CreateElectionsActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }
            }
        });

        mStepCount = findViewById(R.id.step_count);

        viewPager.beginFakeDrag();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                switch (position) {
                    case 0:
                        mPreviousButton.setVisibility(View.INVISIBLE);
                        mStepCount.setText("1 / 5");
                        break;

                    case 1:
                        mPreviousButton.setVisibility(View.VISIBLE);
                        //mNextButton.setVisibility(View.VISIBLE);
                        mNextButton.setText("Next");
                        mStepCount.setText("2 / 5");
                        break;

                    case 2:
                        mPreviousButton.setVisibility(View.VISIBLE);
                        //mNextButton.setVisibility(View.VISIBLE);
                        mNextButton.setText("Next");
                        mStepCount.setText("3 / 5");
                        break;
                    case 3:
                        mPreviousButton.setVisibility(View.VISIBLE);
                        //mNextButton.setVisibility(View.VISIBLE);
                        mNextButton.setText("Next");
                        mStepCount.setText("4 / 5");
                        break;
                    case 4:
                        mPreviousButton.setVisibility(View.VISIBLE);
                        //mNextButton.setVisibility(View.VISIBLE);
                        mNextButton.setText("Finish");
                        mStepCount.setText("5 / 5");
                        break;

                    default:
                        mPreviousButton.setVisibility(View.VISIBLE);
                        //mNextButton.setVisibility(View.VISIBLE);
                        mNextButton.setText("Next");
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
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ElectionDescriptionFragment());
        adapter.addFragment(new ElectionStartEndFragment());
        adapter.addFragment(new AddCandidateFragment());
        adapter.addFragment(new VotingAlgorithmFragment());
        adapter.addFragment(new ElectionPrivacyFragment());
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
}