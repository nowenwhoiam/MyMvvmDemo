package com.arch.demo.common.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiangxue.network.beans.TecentBaseResponse;
import com.xiangxue.network.beans.YunMeiBaseResponse;

import java.util.List;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class YunMeiChannelsBean extends YunMeiBaseResponse {
    @SerializedName("data")
    @Expose
    public List<Data> data;

    @SerializedName("time")
    @Expose
    public String time;

    public class Data {
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("column_id")
        @Expose
        public String columnId;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("source_type")
        @Expose
        public String sourceType;
        @SerializedName("longsun_catid")
        @Expose
        public String longsunCatid;
        @SerializedName("orderId")
        @Expose
        public String orderId;
        @SerializedName("selectid")
        @Expose
        public String selectid;
        @SerializedName("channel")
        @Expose
        public String channel;
        @SerializedName("lmtype")
        @Expose
        public String lmtype;
        @SerializedName("icon")
        @Expose
        public String icon;
        @SerializedName("api")
        @Expose
        public String api;
        @SerializedName("lang")
        @Expose
        public String lang;
        @SerializedName("rel_id")
        @Expose
        public String rel_id;
        @SerializedName("child")
        @Expose
        public String child;
        @SerializedName("arrchild")
        @Expose
        public String arrchild;
        @SerializedName("channel_name")
        @Expose
        public String channel_name;
    }
}
