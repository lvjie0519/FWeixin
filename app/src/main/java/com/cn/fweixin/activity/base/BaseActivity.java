package com.cn.fweixin.activity.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        afterOnCreate(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void afterOnCreate(Bundle savedInstanceState);

}
