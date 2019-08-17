package com.cn.fweixin;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.cn.fweixin.activity.adapter.MainViewPagerAdapter;
import com.cn.fweixin.activity.base.BaseActivity;

public class FWeixinMainActivity extends BaseActivity {

    private ViewPager vpMainPager;
    private TabLayout tbLayoutButtom;


    //未选中的Tab图片
    private int[] unSelectTabRes = new int[]{
            R.mipmap.pic_chat_normal,
            R.mipmap.pic_find_normal,
            R.mipmap.pic_me_normal,};
    //选中的Tab图片
    private int[] selectTabRes = new int[]{
            R.mipmap.pic_chat_press,
            R.mipmap.pic_find_press,
            R.mipmap.pic_me_press,};


    @Override
    protected int getLayoutId() {
        return R.layout.activity_fweixin_main;
    }

    @Override
    protected void afterOnCreate(Bundle savedInstanceState) {
        initView();
        bindListener();
    }

    private void initView(){
        vpMainPager = findViewById(R.id.vp_main_content_view);
        tbLayoutButtom = findViewById(R.id.tb_layout_main_buttom);

        vpMainPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));
        tbLayoutButtom.setupWithViewPager(vpMainPager);

        int len = unSelectTabRes.length;
        for(int i=0; i<len; i++){
            if (i == 0) {
                tbLayoutButtom.getTabAt(0).setIcon(selectTabRes[0]);
            } else {
                tbLayoutButtom.getTabAt(i).setIcon(unSelectTabRes[i]);
            }
        }
    }

    private void bindListener() {
        //TabLayout切换时导航栏图片处理
        tbLayoutButtom.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {//选中图片操作
                for (int i = 0; i < selectTabRes.length; i++) {
                    if (tab == tbLayoutButtom.getTabAt(i)) {
                        tbLayoutButtom.getTabAt(i).setIcon(selectTabRes[i]);
                        vpMainPager.setCurrentItem(i);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {//未选中图片操作
                for (int i = 0; i < unSelectTabRes.length; i++) {
                    if (tab == tbLayoutButtom.getTabAt(i)) {
                        tbLayoutButtom.getTabAt(i).setIcon(unSelectTabRes[i]);
                    }
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }




    }
