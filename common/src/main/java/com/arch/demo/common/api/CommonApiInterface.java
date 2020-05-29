package com.arch.demo.common.api;

import com.arch.demo.common.beans.BannerBean;
import com.arch.demo.common.beans.GroupBean;
import com.arch.demo.common.beans.NewsChannelsBean;
import com.arch.demo.common.beans.NewsListBean;
import com.arch.demo.common.beans.WorkHallBean;
import com.arch.demo.common.beans.WorkServiceAdministrativeBean;
import com.arch.demo.common.beans.YunMeiChannelsBean;
import com.arch.demo.common.beans.YunMeiNewsBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public interface CommonApiInterface {

    /**
     * YunMeiApi_云媒获取云媒新闻列表
     */
    @GET("api/open/newsList")
    Observable<YunMeiNewsBean> getYunMeiNewsList(@Query("tenantid") String tenantid,
                                                 @Query("page") String page,
                                                 @Query("columnid") String columnid,
                                                 @Query("no_headimg") String no_headimg);

    /**
     * YunMeiApi_获取云媒栏目
     */
    @GET("api/open/newsColumn")
    Observable<YunMeiChannelsBean> getYunMeiNewsChannels(@Query("tenantid") String tenantid,
                                                         @Query("lmtype") String lmtype,
                                                         @Query("channel") Integer channel,
                                                         @Query("lang") String lang);

    /**
     * YunMeiApi_获取云媒推荐列表
     * page：分页
     */
    @GET("api/open/newsIndex")
    Observable<YunMeiNewsBean> getRecommendData(@Query("tenantid") String tenantid,
                                                @Query("page") int page);

    /**
     * SSQXApi_办事服务数据（个人办事、法人办事）
     */
    @GET("govcenter/classify_list")
    Observable<WorkHallBean> getWorkServiceData();

    /**
     *  SSQXApi_获取基层办事街道数据（街道办事）
     */
    @GET("jcbs/stree_list")
    Observable<List<WorkServiceAdministrativeBean>> getJCBSStreetData(@Query("lat") String lat,
                                                                      @Query("lng") String lng);

    /**
     *  SSQXApi_首页服务超市数据
     */
    @GET("appentry/home_zhzw_recommend")
    Observable<List<GroupBean>> getSmartAffairData();

    /**
     *  SSQXApi_ 获取天气信息
     */
    @GET("third/interface/weather")
    Observable<List<GroupBean>> getWeatherData(@Query("lat") String lat,
                                               @Query("lng") String lng);

    /**
     * 获取广告列表
     * @param code:广告位
     * @return List<BannerBean>
     */
    @GET("advert/list")
    Observable<List<BannerBean>> getBannerListData(@Query("code") String code);
}
