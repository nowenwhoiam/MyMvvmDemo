package com.example.home.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * ================================================
 * 作    者：zrx
 *
 * 创建时间：2019/7/12
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class HomeNoticeBean {
    @SerializedName("androidAction")
    @Expose
    public String androidAction;

    @SerializedName("title")
    @Expose
    public String title;
}
