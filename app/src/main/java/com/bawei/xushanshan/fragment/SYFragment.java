package com.bawei.xushanshan.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bawei.xushanshan.R;
import com.bawei.xushanshan.adapter.SouAdapter;
import com.bawei.xushanshan.base.BaseFragment;
import com.bawei.xushanshan.bean.SouBean;
import com.bawei.xushanshan.contract.UserContract;

import java.util.List;

import butterknife.BindView;


public class SYFragment extends BaseFragment implements UserContract.IView {


    @BindView(R.id.ed_shu)
    EditText ed_shu;
    private View inflate;
    private RecyclerView recy;
    private LinearLayoutManager linearLayoutManager;
    private List<SouBean.ResultBean> result;
    private SouAdapter souAdapter;

    @Override
    protected View layoutId(LayoutInflater inflater, ViewGroup container) {
        inflate = inflater.inflate(R.layout.fragment_sy, container, false);
        return inflate;
    }

    @Override
    protected void initView() {
        recy = inflate.findViewById(R.id.recy);
        ed_shu = inflate.findViewById(R.id.ed_shu);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onUserSuccess(SouBean success) {
        result = success.getResult();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recy.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        souAdapter = new SouAdapter(getActivity(),result);
        recy.setAdapter(souAdapter);
    }

    @Override
    public void onUserRailure(String e) {

    }

}
