package com.github.luckyshane.systembartint.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.luckyshane.systembartint.R;
import com.github.luckyshane.systembartint.TintBar;

/*
 * @author: luckyShane
 * @date: 2019/3/6
 */
public class DrawerLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);

        TintBar.makeStatusBarTransparent(this);
        //TintBar.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
    }



}
