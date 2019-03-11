package com.github.luckyshane.systembartint.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.luckyshane.systembartint.R;
import com.github.luckyshane.systembartint.TintBar;

/*
 * @author: luckyShane
 * @date: 2019/3/4
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TintBar.fitTitleBar(this, findViewById(R.id.tool_bar));

        findViewById(R.id.fragment_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TabActivity.class));
            }
        });
    }



}
