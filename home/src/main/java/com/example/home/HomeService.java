package com.example.home;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.arch.demo.common.arouter.Home.IHomeService;
import com.example.home.fragment.HomeFragment;

import androidx.fragment.app.Fragment;
@Route(path=IHomeService.HOME_SERVICE)
public class HomeService implements IHomeService {
    @Override
    public void init(Context context) {

    }


    @Override
    public Fragment getHomeFragment() {
        return HomeFragment.getInstance();
    }
}
