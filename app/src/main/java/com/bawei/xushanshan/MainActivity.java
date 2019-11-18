package com.bawei.xushanshan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.xushanshan.adapter.VpAdapter;
import com.bawei.xushanshan.fragment.SYFragment;
import com.bawei.xushanshan.fragment.WDFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

   @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rg)
    RadioGroup rg;
    private ArrayList<Fragment> fragments;
    private VpAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);

     ButterKnife.bind(this);
        fragments = new ArrayList<>();
        fragments.add(new SYFragment());
        fragments.add(new WDFragment());

        vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(vpAdapter);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.but_sy:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.but_wd:
                        vp.setCurrentItem(1);
                        break;

                }
            }
        });
    }





 /*   @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(this).unbind();
    }*/
}
