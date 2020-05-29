package com.example.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.arch.demo.core.customview.BaseCustomViewModel;
import com.arch.demo.core.fragment.MvvmFragment;
import com.example.home.R;
import com.example.home.databinding.FragmentHomeBinding;
import com.example.home.viewmodel.HomeViewModel;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableList;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class HomeFragment extends MvvmFragment<FragmentHomeBinding, HomeViewModel, BaseCustomViewModel>  {

    public static HomeFragment getInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        if (viewModel == null) {
            viewModel = ViewModelProviders.of(this).get(getFragmentTag(), HomeViewModel.class).init();
            Log.e(this.getClass().getSimpleName(), getFragmentTag() + this + ": createViewModel." + viewModel);
            return viewModel;
        }
        return viewModel;
    }

    @Override
    public void onListItemInserted(ObservableList<BaseCustomViewModel> sender) {
        viewDataBinding.refreshLayout.finishLoadMore();
        viewDataBinding.refreshLayout.finishRefresh();
        showSuccess();
    }

    @Override
    protected void initParameters() {

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentTag = "HomeFragment";
        viewDataBinding.refreshLayout.setRefreshHeader(new WaterDropHeader(getContext()));
        viewDataBinding.refreshLayout.setRefreshFooter(new BallPulseFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
        viewDataBinding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                viewModel.tryToRefresh();
            }
        });
        viewDataBinding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                viewModel.tryToLoadNextPage();
            }
        });
        setLoadSir(viewDataBinding.refreshLayout);
        showLoading();
    }

    /***
     * 重试按钮点击
     */
    @Override
    protected void onRetryBtnClick() {
        viewModel.tryToRefresh();
    }

    @Override
    protected String getFragmentTag() {
        return mFragmentTag;
    }

}