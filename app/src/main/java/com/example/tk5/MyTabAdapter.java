package com.example.tk5;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import bean.TaBean;

public class MyTabAdapter extends FragmentPagerAdapter {
     private List<TaBean.DataBean> beans;
    private ArrayList<Fragment> list;

    public MyTabAdapter(FragmentManager fm, List<TaBean.DataBean> beans, ArrayList<Fragment> list) {
        super(fm);
        this.beans = beans;
        this.list = list;
    }



    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return beans.get(position).getName(); //tab的数量
    }
}
