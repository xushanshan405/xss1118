package com.bawei.xushanshan.base;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.xushanshan.R;

/**
 * FileName: BaseActivity
 * Author: 徐姗姗
 * Date: 2019/11/18 9:28
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initData();
    }

    protected abstract int layoutId();

    protected abstract void initView();

    protected abstract void initData();


}
