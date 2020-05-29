package com.example.yunmei.newslist;

import android.text.TextUtils;

import com.arch.demo.common.api.CommonApiInterface;
import com.arch.demo.common.views.banner.BanerViewModel;
import com.arch.demo.common.views.picturetitleview.PictureTitleViewViewModel;
import com.arch.demo.common.views.threePictureTitleView.ThreePictureTitleViewViewModel;
import com.arch.demo.common.views.titleview.TitleViewViewModel;
import com.arch.demo.core.Response.BaseResponse;
import com.arch.demo.core.customview.BaseCustomViewModel;
import com.arch.demo.core.model.MvvmBaseModel;
import com.example.yunmei.api.NewsApiInterface;
import com.arch.demo.common.beans.NewsListBean;
import com.arch.demo.common.beans.YunMeiNewsBean;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.xiangxue.network.YunMeiApi;
import com.xiangxue.network.observer.BaseObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class NewsListModel extends MvvmBaseModel<BaseResponse, ArrayList<BaseCustomViewModel>> {
    private String mChannelId = "";
    private String mChannelName = "";

    public NewsListModel(String channelId, String channelName) {
        super(BaseResponse.class, true, "pref_key_news_" + channelId, null, 1);
        mChannelId = channelId;
        mChannelName = channelName;
    }

    @Override
    public void refresh() {
        isRefresh = true;
        load();
    }

    public void loadNexPage() {
        isRefresh = false;
        load();
    }

    @Override
    protected void load() {
//        TecentNetworkApi.getService(NewsApiInterface.class)
//                .getNewsList(mChannelId, mChannelName, String.valueOf(isRefresh ? 1 : pageNumber))
//                .compose(TecentNetworkApi.
//                        getInstance().
//                        applySchedulers(new BaseObserver<BaseResponse>(this, this)));

        YunMeiApi.getService(CommonApiInterface.class)
                .getYunMeiNewsList("qxy", String.valueOf(isRefresh ? 1 : pageNumber), mChannelId, "0")
                .compose(YunMeiApi.
                        getInstance().
                        applySchedulers(new BaseObserver<BaseResponse>(this, this)));
    }

    @Override
    public void onSuccess(BaseResponse baseResponse, boolean isFromCache) {
         if (baseResponse instanceof YunMeiNewsBean){
             YunMeiNewsBean yunMeiNewsBean= (YunMeiNewsBean) baseResponse;
             if (yunMeiNewsBean == null) {
                 return;
             }
             ArrayList<BaseCustomViewModel> baseViewModels = new ArrayList<>();
             List<YunMeiNewsBean.Data> headimg = yunMeiNewsBean.headimg;
             if (headimg!=null){
                 ArrayList<String> urlList = new ArrayList<>();
                 ArrayList<String> titleList = new ArrayList<>();
                 BanerViewModel banerViewModel = new BanerViewModel();
                 for (YunMeiNewsBean.Data headBean :headimg){
                     urlList.add(headBean.imgsrc);
                     titleList.add(headBean.title);
                 }
                 banerViewModel.bannerUrlList=urlList;
                 banerViewModel.titleList=titleList;
                 banerViewModel.delayTime=4000;
                 baseViewModels.add(banerViewModel);
             }
             List<YunMeiNewsBean.Data> dataList = yunMeiNewsBean.data;
             if (dataList != null) {
                 for (YunMeiNewsBean.Data source : dataList) {
                     String list_type = source.list_type;
                     if (!TextUtils.isEmpty(list_type) && list_type.equals("0")) {
                         //图文模式
                         PictureTitleViewViewModel viewModel = new PictureTitleViewViewModel();
                         viewModel.avatarUrl = source.imgsrc;
                         viewModel.jumpUri = source.url;
                         viewModel.title = source.title;
                         baseViewModels.add(viewModel);
                     } else if (!TextUtils.isEmpty(list_type) && list_type.equals("1")) {
                         //三图模式
                         ThreePictureTitleViewViewModel viewViewModel = new ThreePictureTitleViewViewModel();
                         List<String> avatarUrlList = new ArrayList<>();
                         List<YunMeiNewsBean.ImgExyraBean> imgextraList = source.imgextra;
                         if (imgextraList!=null){
                             for (YunMeiNewsBean.ImgExyraBean imgExyraBean : imgextraList) {
                                 avatarUrlList.add(imgExyraBean.imgsrc);
                             }
                         }
                         viewViewModel.avatarUrlList = avatarUrlList;
                         viewViewModel.title = source.title;
                         viewViewModel.jumpUri = source.url;
                         baseViewModels.add(viewViewModel);
                     }else {
                         TitleViewViewModel viewModel = new TitleViewViewModel();
                         viewModel.jumpUri = source.url;
                         viewModel.title = source.title;
                         baseViewModels.add(viewModel);
                     }
                 }
                 loadSuccess(yunMeiNewsBean, baseViewModels, isFromCache);
             }
         }else if (baseResponse instanceof NewsListBean){
             NewsListBean newsListBean= (NewsListBean) baseResponse;
             String json = new Gson().toJson(newsListBean);
             Logger.e("NewsListBean:"+json);
         }

    }

    @Override
    public void onFailure(Throwable e) {
        e.printStackTrace();
        loadFail(e.getMessage());
    }
}
