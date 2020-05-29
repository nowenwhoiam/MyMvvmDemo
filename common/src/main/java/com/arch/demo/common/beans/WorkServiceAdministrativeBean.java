package com.arch.demo.common.beans;

import android.os.Build;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiangxue.network.beans.SSQXBaseResponse;

import java.util.Objects;

/**
 * ================================================
 * 作    者：zrx
 * <p>
 * 创建时间：2019/4/9
 * 描    述：办事服务-街道/乡镇实体类
 * 修订历史：
 * ================================================
 */
public class WorkServiceAdministrativeBean extends SSQXBaseResponse {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("projectId")
    @Expose
    public String projectId;
    @SerializedName("abbreviation")
    @Expose
    public String abbreviation;

    public WorkServiceAdministrativeBean(String id, String abbreviation) {
        this.id = id;
        this.abbreviation = abbreviation;
    }

}
