package com.arch.demo.common.views.banner;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.arch.demo.common.R;
import com.arch.demo.common.databinding.BannerViewBinding;
import com.arch.demo.common.databinding.PictureTitleViewBinding;
import com.arch.demo.common.utils.CommonUtil;
import com.arch.demo.common.utils.GlideImageLoader;
import com.arch.demo.common.views.picturetitleview.PictureTitleViewViewModel;
import com.arch.demo.core.customview.BaseCustomView;
import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.Logger;
import com.xiangxue.webview.WebviewActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class BannerView extends BaseCustomView<BannerViewBinding, BanerViewModel> {
    private Context mContxt;
    public BannerView(Context context) {
        super(context);
        mContxt=context;
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContxt=context;
    }

    @Override
    public int setViewLayoutId() {
        return R.layout.banner_view;
    }

    @Override
    public void setDataToView(BanerViewModel data) {
        BannerViewBinding bannerViewBinding = getDataBinding();
        //设置图片集合
        Banner banner = bannerViewBinding.banner;
        if (data==null){
            banner.setVisibility(GONE);
            return;
        }
        if (data.bannerUrlList==null||data.bannerUrlList.size()==0){
            banner.setVisibility(GONE);
            return;
        }
        banner.setVisibility(VISIBLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(data.bannerUrlList);
//        banner.setBannerTitles(data.titleList);
        banner.setDelayTime(data.delayTime);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                String action = data.action;
                String androidAction = data.androidAction;
                String url=data.bannerUrlList.get(position);
                switch (action) {
                    case "0"://不做动作
                        ToastUtils.show("开发中...");
                        break;
                    case "1"://跳转web链接
                        if (!TextUtils.isEmpty(androidAction) && CommonUtil.isCorrectUrl(androidAction)) {
                            WebviewActivity.startCommonWeb(mContxt, "", url);
                        }
                        break;
                    case "2"://跳转app
                        String appPackageName = androidAction;
                        if (CommonUtil.isInstalledApp(mContxt, appPackageName)) {
                            //根据包名来跳转  不能指定跳转界面
                            Intent intent = mContxt.getPackageManager().getLaunchIntentForPackage(appPackageName);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            mContxt.startActivity(intent);
                        }
                        break;
                }
            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        getDataBinding().setViewModel(data);
    }

    @Override
    protected void onRootClick(View view) {

    }

}
