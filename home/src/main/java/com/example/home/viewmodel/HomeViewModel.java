package com.example.home.viewmodel;

import com.arch.demo.core.customview.BaseCustomViewModel;
import com.arch.demo.core.viewmodel.MvvmBaseViewModel;
import com.example.home.model.HomeModel;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class HomeViewModel extends MvvmBaseViewModel<HomeModel, BaseCustomViewModel> {
    public HomeViewModel init() {
        model = new HomeModel();
        model.register(this);
        model.getCachedDataAndLoad();
        return this;
    }

    public void tryToLoadNextPage() {
        model.loadNexPage();
    }
}
