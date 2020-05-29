package com.arch.demo.common.arouter.Home;

import com.alibaba.android.arouter.facade.template.IProvider;

import androidx.fragment.app.Fragment;

public interface IHomeService extends IProvider {
    String HOME_ROUTER = "/home/";
    String HOME_SERVICE = HOME_ROUTER + "home_service";
    Fragment getHomeFragment();
}
