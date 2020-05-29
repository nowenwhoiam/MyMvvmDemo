package com.arch.demo.common.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiangxue.network.beans.YunMeiBaseResponse;

import java.util.Date;
import java.util.List;

/**
 * ================================================
 *
 * @author ：zrx
 * @date：2020/5/20 描    述:
 * 修订历史：
 * ================================================
 */
public class YunMeiNewsBean extends YunMeiBaseResponse{
    @SerializedName("headimg")
    @Expose
    public List<Data> headimg;

    @SerializedName("data")
    @Expose
    public List<Data> data;

    @SerializedName("time")
    @Expose
    public long time;

    public class ImgExyraBean{
        @SerializedName("imgsrc")
        @Expose
        public String imgsrc;

        @SerializedName("alt")
        @Expose
        public String alt;

    }

    public  class Data {
        @SerializedName("id")
        @Expose
        public String id;

        @SerializedName("imgextra")
        @Expose
        public List<ImgExyraBean> imgextra;

        @SerializedName("title")
        @Expose
        public String title;

        @SerializedName("url")
        @Expose
        public String url;

        @SerializedName("link")
        @Expose
        public String link;


        @SerializedName("docid")
        @Expose
        public String docid;

        @SerializedName("vid")
        @Expose
        public String vid;

        @SerializedName("news_type")
        @Expose
        public String news_type;

        @SerializedName("column_id")
        @Expose
        public String column_id;

        @SerializedName("column")
        @Expose
        public String column;

        @SerializedName("digest")
        @Expose
        public String digest;

        @SerializedName("has_sound")
        @Expose
        public String has_sound;

        @SerializedName("play_type")
        @Expose
        public String play_type;

        @SerializedName("source_face")
        @Expose
        public String source_face;

        @SerializedName("source_type")
        @Expose
        public String source_type;

        @SerializedName("source")
        @Expose
        public String source;

        @SerializedName("rel_id")
        @Expose
        public String rel_id;

        @SerializedName("rel")
        @Expose
        public String rel;

        @SerializedName("ad_size")
        @Expose
        public String ad_size;

        @SerializedName("label")
        @Expose
        public String label;

        @SerializedName("comment_count")
        @Expose
        public int comment_count;

        @SerializedName("praise")
        @Expose
        public int praise;

        @SerializedName("is_top")
        @Expose
        public int is_top;

        @SerializedName("open_view")
        @Expose
        public String open_view;

        @SerializedName("fav_state")
        @Expose
        public String fav_state;

        @SerializedName("content_type")
        @Expose
        public String content_type;

        @SerializedName("update_time")
        @Expose
        public String update_time;

        @SerializedName("ptime")
        @Expose
        public String ptime;

        @SerializedName("imgsrc")
        @Expose
        public String imgsrc;

        @SerializedName("list_type")
        @Expose
        public String list_type;

        @SerializedName("image_long")
        @Expose
        public String image_long;

        @SerializedName("cover")
        @Expose
        public String cover;

        @SerializedName("url_mp4")
        @Expose
        public String url_mp4;

        @SerializedName("mp4_url")
        @Expose
        public String mp4_url;

        @SerializedName("has_video")
        @Expose
        public int has_video;

    }
}
