package com.arch.demo.common.arouter.yunmei;

import com.alibaba.android.arouter.facade.template.IProvider;

import androidx.fragment.app.Fragment;


public interface IYunMeiService extends IProvider {
    String YUNMEI_ROUTER = "/yunmei/";
    String YUNMEI_SERVICE = YUNMEI_ROUTER + "yunmei_service";
    Fragment getHeadlineNewsFragment();
}
