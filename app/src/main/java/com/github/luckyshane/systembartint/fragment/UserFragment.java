package com.github.luckyshane.systembartint.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.luckyshane.systembartint.R;
import com.github.luckyshane.systembartint.TintBar;

/*
 * @author: luckyShane
 * @date: 2019/3/11
 */
public class UserFragment extends Fragment {
    private Handler handler = new Handler();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TintBar.fitTitleBar(getActivity(), view.findViewById(R.id.toolbar));
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    TintBar.setStatusBarLightMode(getActivity(), true);
                }
            });
        }
    }

}
