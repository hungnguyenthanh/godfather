package com.snapsofts.doopapp.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.snapsofts.doopapp.R;
import com.snapsofts.doopapp.ui.fragment.ListCategoryFragment;

public class ListCategoryActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons(tabLayout);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return ListCategoryFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    private void setupTabIcons(TabLayout tabLayout) {
        TextView newTab = (TextView) LayoutInflater.from(this).inflate(R.layout.item_tab_category, null);
        newTab.setText("Coupons"); //tab label txt
        newTab.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_tab_coupons, 0, 0, 0);
        tabLayout.getTabAt(0).setCustomView(newTab);
        newTab = (TextView) LayoutInflater.from(this).inflate(R.layout.item_tab_category, null);
        newTab.setText("Deals"); //tab label txt
        newTab.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_tab_deals, 0, 0, 0);
        tabLayout.getTabAt(1).setCustomView(newTab);
        newTab = (TextView) LayoutInflater.from(this).inflate(R.layout.item_tab_category, null);
        newTab.setText("Local Stores"); //tab label txt
        newTab.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_tab_local, 0, 0, 0);
        tabLayout.getTabAt(2).setCustomView(newTab);
        setTabPadding(tabLayout);


    }

    private void setTabPadding(TabLayout mTabLayout){
        for(int i=0; i < mTabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(0, 0, 5, 0);
            tab.requestLayout();
        }
    }
}
