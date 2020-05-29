package com.arch.demo.common.views.threePictureTitleView;

import android.content.Context;
import android.view.View;

import com.arch.demo.common.R;
import com.arch.demo.common.databinding.ThreePictureTitleViewBinding;
import com.arch.demo.core.customview.BaseCustomView;
import com.arch.demo.core.customview.BaseCustomViewModel;
import com.xiangxue.webview.WebviewActivity;

/**
 * ================================================
 *
 * @author ：zrx
 * @date：2020/5/20 描    述:三图
 * 修订历史：
 * ================================================
 */
public class ThreePictureTitleView extends BaseCustomView<ThreePictureTitleViewBinding,ThreePictureTitleViewViewModel> {
    public ThreePictureTitleView(Context context) {
        super(context);
    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.three_picture_title_view;
    }

    @Override
    protected void setDataToView(ThreePictureTitleViewViewModel data) {
        getDataBinding().setViewModel(data);
    }


    @Override
    protected void onRootClick(View view) {
        WebviewActivity.startCommonWeb(view.getContext(), "", getViewModel().jumpUri);
    }
}
