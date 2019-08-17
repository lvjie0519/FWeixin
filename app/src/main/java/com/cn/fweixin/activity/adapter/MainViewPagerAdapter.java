package com.cn.fweixin.activity.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cn.fweixin.fragment.ChartMainTabFragment;
import com.cn.fweixin.fragment.FindMainTabFragment;
import com.cn.fweixin.fragment.MeMainTabFragment;
import com.cn.fweixin.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private Class[] fragmentsClass = {
            ChartMainTabFragment.class,
            FindMainTabFragment.class,
            MeMainTabFragment.class
    };
    //Tab标题
    private String[] pageTitles = new String[]{"聊天", "发现", "我"};

    private List<BaseFragment> mFragments;

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);

        initData();
    }

    private void initData(){
        if(mFragments == null){
            mFragments = new ArrayList<>();
        }
        mFragments.clear();
        int len = fragmentsClass.length;
        for(int i=0; i<len; i++){
            try {
                mFragments.add((BaseFragment) fragmentsClass[i].newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }
}
