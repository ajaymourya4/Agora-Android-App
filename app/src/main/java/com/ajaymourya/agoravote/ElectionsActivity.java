package com.ajaymourya.agoravote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.ajaymourya.agoravote.fragments.ActiveElectionsFragment;
import com.ajaymourya.agoravote.fragments.AllElectionsFragment;
import com.ajaymourya.agoravote.fragments.FinishedElectionsFragment;
import com.ajaymourya.agoravote.fragments.PendingElectionsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ElectionsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elections);

        Intent intent = getIntent();
        int targetFragment = intent.getIntExtra("TARGET_FRAGMENT", 0);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setCurrentItem(targetFragment);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setTabLayoutandToolBarColor(targetFragment);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tabLayout.setBackgroundColor(getColor(R.color.colorTotalElection));
                        toolbar.setBackgroundColor(getColor(R.color.colorTotalElection));
                        break;
                    case 1:
                        tabLayout.setBackgroundColor(getColor(R.color.colorPendingElection));
                        toolbar.setBackgroundColor(getColor(R.color.colorPendingElection));
                        break;
                    case 2:
                        tabLayout.setBackgroundColor(getColor(R.color.colorActiveElection));
                        toolbar.setBackgroundColor(getColor(R.color.colorActiveElection));
                        break;
                    case 3:
                        tabLayout.setBackgroundColor(getColor(R.color.colorFinishedElection));
                        toolbar.setBackgroundColor(getColor(R.color.colorFinishedElection));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setTabLayoutandToolBarColor(int targetFragment) {
        switch (targetFragment) {
            case 0:
                tabLayout.setBackgroundColor(getColor(R.color.colorTotalElection));
                toolbar.setBackgroundColor(getColor(R.color.colorTotalElection));
                break;
            case 1:
                tabLayout.setBackgroundColor(getColor(R.color.colorPendingElection));
                toolbar.setBackgroundColor(getColor(R.color.colorPendingElection));
                break;
            case 2:
                tabLayout.setBackgroundColor(getColor(R.color.colorActiveElection));
                toolbar.setBackgroundColor(getColor(R.color.colorActiveElection));
                break;
            case 3:
                tabLayout.setBackgroundColor(getColor(R.color.colorFinishedElection));
                toolbar.setBackgroundColor(getColor(R.color.colorFinishedElection));
                break;
            default:
                break;
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AllElectionsFragment(), "ALL");
        adapter.addFragment(new PendingElectionsFragment(), "PENDING");
        adapter.addFragment(new ActiveElectionsFragment(), "ACTIVE");
        adapter.addFragment(new FinishedElectionsFragment(), "FINISHED");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

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

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
