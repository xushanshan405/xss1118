package com.bawei.xushanshan.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.xushanshan.R;
import com.bawei.xushanshan.base.BaseFragment;


public class WDFragment extends BaseFragment {
    private View inflate;
    private ImageView im;
    private Intent intent;
    private int REQUEST_CODE_SELECT_PHOTO;
    @Override
    protected View layoutId(LayoutInflater inflater, ViewGroup container) {
        inflate = inflater.inflate(R.layout.fragment_wd, container, false);
        return inflate;
    }

    @Override
    protected void initView() {
        im = inflate.findViewById(R.id.im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,REQUEST_CODE_SELECT_PHOTO);
            }
        });
    }

    @Override
    protected void initData() {

    }
}
