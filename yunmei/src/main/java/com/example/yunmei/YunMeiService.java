package com.example.yunmei;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.arch.demo.common.arouter.yunmei.IYunMeiService;
import com.example.yunmei.headlinenews.HeadlineNewsFragment;

import androidx.fragment.app.Fragment;

@Route(path = IYunMeiService.YUNMEI_SERVICE)
public class YunMeiService implements IYunMeiService {
    @Override
    public void init(Context context) {

    }

    @Override
    public Fragment getHeadlineNewsFragment() {
        return new HeadlineNewsFragment();
    }
}
