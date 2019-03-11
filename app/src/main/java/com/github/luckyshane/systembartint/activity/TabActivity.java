package com.github.luckyshane.systembartint.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.luckyshane.systembartint.R;
import com.github.luckyshane.systembartint.TintBar;
import com.github.luckyshane.systembartint.fragment.ExploreFragment;
import com.github.luckyshane.systembartint.fragment.HomeFragment;
import com.github.luckyshane.systembartint.fragment.LightModeFragment;
import com.github.luckyshane.systembartint.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: luckyShane
 * @date: 2019/3/11
 */
public class TabActivity extends AppCompatActivity {

    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager viewPager;
    private List<View> tabViews = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        TintBar.makeStatusBarTransparent(this);

        viewPager = findViewById(R.id.view_pager);

        fragmentList.add(new HomeFragment());
        fragmentList.add(new ExploreFragment());
        fragmentList.add(new UserFragment());
        fragmentList.add(new LightModeFragment());

        tabViews.add(findViewById(R.id.tab_home));
        tabViews.add(findViewById(R.id.tab_explore));
        tabViews.add(findViewById(R.id.tab_me));
        tabViews.add(findViewById(R.id.tab_light_mode));

        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                for (int j = 0; j < tabViews.size(); j++) {
                    tabViews.get(j).setSelected(j == i);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        tabViews.get(0).performClick();
        tabViews.get(0).setSelected(true);
    }


    public void onTabClick(View view) {
        int index = tabViews.indexOf(view);
        if (index != -1) {
            viewPager.setCurrentItem(index);
        }
    }

    private class TabAdapter extends FragmentPagerAdapter {

        TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }






}
