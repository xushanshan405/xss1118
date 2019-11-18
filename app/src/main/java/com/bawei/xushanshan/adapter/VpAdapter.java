package com.bawei.xushanshan.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * FileName: VpAdapter
 * Author: 徐姗姗
 * Date: 2019/11/18 9:19
 */
public class VpAdapter extends FragmentPagerAdapter {
    FragmentManager supportFragmentManager;
    ArrayList<Fragment> fragments;
    public VpAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragments) {
        super(supportFragmentManager);
        this.supportFragmentManager = supportFragmentManager;
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
