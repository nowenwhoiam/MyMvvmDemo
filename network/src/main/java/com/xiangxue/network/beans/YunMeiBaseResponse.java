package com.xiangxue.network.beans;

import com.arch.demo.core.Response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class YunMeiBaseResponse extends BaseResponse {
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("msg")
    @Expose
    public String msg;
}
