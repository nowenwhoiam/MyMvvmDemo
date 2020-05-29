package com.example.yunmei.newslist;

import android.view.ViewGroup;

import com.arch.demo.common.views.banner.BanerViewModel;
import com.arch.demo.common.views.banner.BannerView;
import com.arch.demo.common.views.picturetitleview.PictureTitleView;
import com.arch.demo.common.views.picturetitleview.PictureTitleViewViewModel;
import com.arch.demo.common.views.threePictureTitleView.ThreePictureTitleView;
import com.arch.demo.common.views.threePictureTitleView.ThreePictureTitleViewViewModel;
import com.arch.demo.common.views.titleview.TitleView;
import com.arch.demo.common.views.titleview.TitleViewViewModel;
import com.arch.demo.core.customview.BaseCustomViewModel;
import com.arch.demo.core.recyclerview.BaseViewHolder;

import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class NewsListRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private ObservableList<BaseCustomViewModel> mItems;
    private final int VIEW_TYPE_PICTURE_TITLE = 1;
    private final int VIEW_TYPE_TITLE = 2;
    private final int VIEW_TYPE_THREE_PICTURE_TITLE = 3;
    private final int VIEW_TYPE_BANNER = 4;

    NewsListRecyclerViewAdapter() {

    }

    void setData(ObservableList<BaseCustomViewModel> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mItems != null && mItems.size() > 0) {
            return mItems.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if(mItems.get(position) instanceof PictureTitleViewViewModel){
            return VIEW_TYPE_PICTURE_TITLE;
        } else if(mItems.get(position) instanceof TitleViewViewModel){
            return VIEW_TYPE_TITLE;
        }else if(mItems.get(position) instanceof ThreePictureTitleViewViewModel){
            return VIEW_TYPE_THREE_PICTURE_TITLE;
        }else if (mItems.get(position) instanceof BanerViewModel){
            return VIEW_TYPE_BANNER;
        }
        return -1;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_PICTURE_TITLE) {
            PictureTitleView pictureTitleView = new PictureTitleView(parent.getContext());
            return new BaseViewHolder(pictureTitleView);
        } else if(viewType == VIEW_TYPE_TITLE) {
            TitleView titleView = new TitleView(parent.getContext());
            return new BaseViewHolder(titleView);
        }else if (viewType == VIEW_TYPE_THREE_PICTURE_TITLE){
            ThreePictureTitleView threePictureTitleView = new ThreePictureTitleView(parent.getContext());
            return new BaseViewHolder(threePictureTitleView);
        }else if (viewType == VIEW_TYPE_BANNER){
            BannerView bannerView=new BannerView(parent.getContext());
            return new BaseViewHolder(bannerView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }
}
