package com.arch.demo.common.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiangxue.network.beans.SSQXBaseResponse;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * ================================================
 * 作    者：zrx
 * <p>
 * 创建时间：2019/3/29
 * 描    述：首页广告实体类
 * 修订历史：
 * ================================================
 */
public class BannerBean extends SSQXBaseResponse {

    @SerializedName("dept")
    @Expose
    public String sort;

    @SerializedName("dept")
    @Expose
    public List<AdvBean> adv;

    public class AdvBean implements Serializable {

        @SerializedName("dept")
        @Expose
        public String title;
        public String imgUrl;

        @SerializedName("dept")
        @Expose
        public String androidAction;

        @SerializedName("dept")
        @Expose
        public String action;

        @SerializedName("dept")
        @Expose
        public String actionParam;

        @SerializedName("dept")
        @Expose
        public String webContent;
    }
}
