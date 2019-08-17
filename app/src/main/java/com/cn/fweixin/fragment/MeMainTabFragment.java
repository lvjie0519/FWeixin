package com.cn.fweixin.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.fweixin.R;
import com.cn.fweixin.fragment.base.BaseFragment;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class MeMainTabFragment extends BaseFragment {


    public MeMainTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me_main_tab, container, false);
    }

}
