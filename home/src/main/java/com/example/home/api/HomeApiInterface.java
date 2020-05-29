package com.example.home.api;


import com.arch.demo.common.beans.YunMeiChannelsBean;
import com.arch.demo.common.beans.YunMeiNewsBean;
import com.example.home.bean.HomeNoticeBean;
import com.example.home.bean.RecordsBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public interface HomeApiInterface {

    /**
     * SSQXApi_获取首页通知（跑马灯）
     */
    @GET("advert/appHomeTzgg?tdsourcetag=s_pcqq_aiomsg")
    Observable<HomeNoticeBean> getNoticeData();

    /**
     * SSQXApi_政务公开
     */
    @GET("article/zwgktjList")
    Observable<List<RecordsBean>> getArtivleListData();

}
