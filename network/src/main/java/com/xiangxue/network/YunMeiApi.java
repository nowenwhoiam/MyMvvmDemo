package com.xiangxue.network;

import com.xiangxue.network.base.NetworkApi;
import com.xiangxue.network.beans.TecentBaseResponse;
import com.xiangxue.network.beans.YunMeiBaseResponse;
import com.xiangxue.network.errorhandler.ExceptionHandle;
import com.xiangxue.network.utils.TecentUtil;

import java.io.IOException;

import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class YunMeiApi extends NetworkApi {
    private static volatile YunMeiApi sInstance;

    public static YunMeiApi getInstance() {
        if (sInstance == null) {
            synchronized (YunMeiApi.class) {
                if (sInstance == null) {
                    sInstance = new YunMeiApi();
                }
            }
        }
        return sInstance;
    }

    public static  <T> T getService(Class<T> service) {
        return getInstance().getRetrofit(service).create(service);
    }

    @Override
    protected Interceptor getInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String timeStr = TecentUtil.getTimeStr();
                Request.Builder builder = chain.request().newBuilder();
//                builder.addHeader("Source", "source");
//                builder.addHeader("Authorization", TecentUtil.getAuthorization(timeStr));
//                builder.addHeader("Date", timeStr);
                return chain.proceed(builder.build());
            }
        };
    }

    @Override
    protected <T> Function<T, T> getAppErrorHandler() {
        return new Function<T, T>() {
            @Override
            public T apply(T response) throws Exception {
                //response中code码不为1则出现错误
                if (response instanceof YunMeiBaseResponse && ((YunMeiBaseResponse) response).code != 1) {
                    ExceptionHandle.ServerException exception = new ExceptionHandle.ServerException();
                    exception.code = ((YunMeiBaseResponse) response).code;
                    exception.message = ((YunMeiBaseResponse) response).msg != null ? ((YunMeiBaseResponse) response).msg : "";
                    throw exception;
                }
                return response;
            }
        };
    }

    @Override
    public String getFormal() {
        return "http://www.sogx.cn/";
    }

    @Override
    public String getTest() {
        return "http://www.sogx.cn/";
    }
}
