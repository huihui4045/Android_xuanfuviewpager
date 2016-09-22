package com.ssy.xuanfuviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by gavin on 2016/9/22.
 */
public class ResumeAdapter extends FragmentPagerAdapter {

    private ViewPager viewPager;

    public ResumeAdapter(ViewPager viewPager, FragmentManager fm) {
        super(fm);
        this.viewPager = viewPager;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (0 == position) {
            fragment = new SummaryFrag();
        } else if (1 == position) {
            fragment = new CatalogFrag();
        } else if (2 == position) {
            fragment = new EvaluateFrag();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TAB 1";
            case 1:
                return "TAB 2";
            case 2:
                return "TAB 3";
        }
        return null;
    }
}
