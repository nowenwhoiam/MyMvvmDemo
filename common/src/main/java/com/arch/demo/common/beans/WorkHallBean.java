package com.arch.demo.common.beans;

import android.os.Build;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiangxue.network.beans.SSQXBaseResponse;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * ================================================
 * 作    者：zrx
 *
 * 创建时间：2019/3/25
 * 描    述：办事大厅实体类
 * 修订历史：
 * ================================================
 */
public class WorkHallBean extends SSQXBaseResponse {
    @SerializedName("theme")
    @Expose
    public List<DataBean> theme;
    @SerializedName("dept")
    @Expose
    public List<DataBean> dept;


    public WorkHallBean(List<DataBean> theme, List<DataBean> dept, String title) {
        this.theme = theme;
        this.dept = dept;
    }



    public static class  DataBean implements Serializable {
        @SerializedName("id")
        @Expose
        public String id;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("imgUrl")
        @Expose
        public String imgUrl;

        @SerializedName("clsType")
        @Expose
        public String clsType;
    }
}
