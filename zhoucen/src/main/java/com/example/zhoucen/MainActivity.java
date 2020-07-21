package com.example.zhoucen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import Fragment.ShouFragment;
import Fragment.WoFragment;

public class MainActivity extends AppCompatActivity {

    /**
     * 首页
     */
    private TextView mShou;
    private Toolbar mTool;
    private NavigationView mNav;
    private DrawerLayout mDra;
    private ShouFragment shouFragment;
    private WoFragment woFragment;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mShou = (TextView) findViewById(R.id.shou);
        mTool = (Toolbar) findViewById(R.id.Tool);
        mDra = (DrawerLayout) findViewById(R.id.Dra);
        setSupportActionBar(mTool);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDra, mTool, R.string.app_name, R.string.app_name);
        mDra.addDrawerListener(toggle);
        toggle.syncState();
        manager = getSupportFragmentManager();
        shouFragment = new ShouFragment();
        woFragment = new WoFragment();
        manager.beginTransaction().add(R.id.fragment, shouFragment).add(R.id.fragment, woFragment).hide(woFragment).commit();
        mNav = (NavigationView) findViewById(R.id.Nav);
        mNav.setItemIconTintList(null);
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item:
                        mShou.setText("首页");
                        manager.beginTransaction().show(shouFragment).hide(woFragment).commit();
                        break;
                    case R.id.item1:
                        mShou.setText("我的");
                        manager.beginTransaction().show(woFragment).hide(shouFragment).commit();
                        break;
                }
                return false;
            }
        });
    }
}
