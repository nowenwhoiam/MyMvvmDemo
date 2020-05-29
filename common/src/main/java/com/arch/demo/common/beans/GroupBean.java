package com.arch.demo.common.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiangxue.network.beans.SSQXBaseResponse;

import java.io.Serializable;

/**
 * ================================================
 * 作    者：zrx
 *
 * 创建时间：2019/4/2
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class GroupBean extends SSQXBaseResponse {
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;

    @SerializedName("dept")
    @Expose
    public String id;

    @SerializedName("dept")
    @Expose
    public String pid;

    @SerializedName("dept")
    @Expose
    public String title;

    @SerializedName("dept")
    @Expose
    public String iconUrl;

    @SerializedName("dept")
    @Expose
    public String brief;

    @SerializedName("dept")
    @Expose
    public String action;//动作类型0:none  1:web  2:open app

    @SerializedName("dept")
    @Expose
    public String actionPage1;//动作地址（Android）

    @SerializedName("dept")
    @Expose
    public String actionPage2;//动作地址（ios）

    @SerializedName("dept")
    @Expose
    public String webContent;//web脚本

    @SerializedName("dept")
    @Expose
    public String url;

    @SerializedName("dept")
    @Expose
    public int itemType;//布局类型

    @SerializedName("dept")
    @Expose
    public int iconID;

    @SerializedName("dept")
    @Expose
    public String code;//20190829新增
    

    public GroupBean(String title, int iconID) {
        this.title = title;
        this.iconID = iconID;
    }

    public GroupBean(String title, String url, int iconID) {
        this.title = title;
        this.url = url;
        this.iconID = iconID;
    }

    public GroupBean(String id, String title, int iconID, int itemType) {
        this.id = id;
        this.title = title;
        this.iconID = iconID;
        this.itemType = itemType;
    }
    
}
