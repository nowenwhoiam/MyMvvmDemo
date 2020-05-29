package com.example.home.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiangxue.network.beans.SSQXBaseResponse;

import java.util.List;

/**
 * ================================================
 *
 * @author ：zrx
 * @date：2020/5/29 描    述:
 * 修订历史：
 * ================================================
 */
public class RecordsBean extends SSQXBaseResponse {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("brief")
    @Expose
    private String brief;

    @SerializedName("pubTime")
    @Expose
    private String pubTime;

    @SerializedName("ptime")
    @Expose
    private String ptime;

    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;

    @SerializedName("tags")
    @Expose
    private String tags;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("imgs")
    @Expose
    private List<String> imgs;

    @SerializedName("type")
    @Expose
    private int type;//0无图 1单图 2双图 3三图
}
