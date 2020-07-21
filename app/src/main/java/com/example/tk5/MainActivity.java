package com.example.tk5;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bean.TaBean;
import p.Loginp;
import view.Loginview;

public class MainActivity extends AppCompatActivity implements Loginview {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Loginp loginp = new Loginp(this);
        loginp.getData();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.Tab);
        mVp = (ViewPager) findViewById(R.id.vp);
    }

    @Override
    public void shouToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setdata(List<TaBean.DataBean> dataBeans) {
        list = new ArrayList<Fragment>(); //集合
        for (int i = 0; i < dataBeans.size(); i++) {
            VpFragment vpFragment = new VpFragment();
            int id = dataBeans.get(i).getId();
            Bundle bundle = new Bundle();
            bundle.putString("cid", id + "");
            vpFragment.setArguments(bundle);
            list.add(vpFragment);
        }
        MyTabAdapter adapter = new MyTabAdapter(getSupportFragmentManager(), dataBeans, list); //创建适配器
        mVp.setAdapter(adapter); //绑定适配器
        mTab.setupWithViewPager(mVp);  // tab和viewpager联动
    }
}
