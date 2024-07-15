package com.example.android2.demo4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Demo43Adapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>(); // list chua fragmnt
    private final List<String> fragmentTitel = new ArrayList<>();
    public Demo43Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    // viet phuong thuc lay titel

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitel.get(position);
    }

    // viet phuong thuc them fragment;
    public void AddFrag(Fragment fragment,String titel){
        fragmentList.add(fragment);
        fragmentTitel.add(titel);

    }
}
