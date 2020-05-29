package com.arch.demo.common.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import com.arch.demo.core.utils.Logger;
import com.hjq.toast.ToastUtils;


import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static android.os.Build.VERSION.SDK_INT;

/**
 * ================================================
 * 作    者：zrx
 * <p>
 * 创建日期：2019.3.8
 * 描    述:通用工具类
 * 修订历史：
 * ================================================
 */

public class CommonUtil {


    /**
     * 判断某个界面是否在前台
     *
     * @param context
     * @param className 某个界面名称
     */
    public static boolean isForeground(Context context, String className) {
        if (context == null || TextUtils.isEmpty(className)) {
            return false;
        }

        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(1);
        if (list != null && list.size() > 0) {
            ComponentName cpn = list.get(0).topActivity;
            if (className.equals(cpn.getClassName())) {
                return true;
            }
        }
        return false;
    }


    /*
     * 当前时刻
     */
    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(String stamp) {
        if (TextUtils.isEmpty(stamp)) return null;
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(stamp);
        Date date = new Date(lt * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }




    /**
     * 判断app是否存在
     *
     * @param myContext
     * @param appPackageName
     * @return
     */
    public static boolean isInstalledApp(Context myContext, String appPackageName) {
        return isInstalledApp(myContext, appPackageName, "您的手机没有安装该应用");
    }

    /**
     * 判断app是否存在
     *
     * @param myContext
     * @param appPackageName
     * @return
     */
    public static boolean isInstalledApp(Context myContext, String appPackageName, String msg) {
        PackageManager myPackageMgr = myContext.getPackageManager();
        try {
            //20191031 PackageManager.GET_ACTIVITIES改为PackageManager.GET_UNINSTALLED_PACKAGES，原因：部分手机报异常android.os.DeadObjectException
            myPackageMgr.getPackageInfo(appPackageName, PackageManager.GET_UNINSTALLED_PACKAGES);
        } catch (PackageManager.NameNotFoundException e) {
            ToastUtils.show(msg);
            return (false);
        } catch (Exception e) {
            ToastUtils.show(msg);
            return (false);
        }
        return true;
    }


    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mul(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.multiply(b2).doubleValue();
    }


    /**
     * 判断url是否规范
     */
    public static boolean isCorrectUrl(String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }

    /**
     * 根据传入的URL获取一级域名
     *
     * @param url
     * @return
     */
    public static String getDomain(String url) {
        String domain = "";
        if (!TextUtils.isEmpty(url) && url.startsWith("http")) {
            try {
                domain = Uri.parse(url).getHost();
            } catch (Exception ex) {
            }
        }
        return domain;
    }



    /**
     * 根据服务器判断跳转页面
     */
    public static void gotoActivity(Context context, String pageUrl, boolean isLogin) {
//        // step 1
//        if (TextUtils.isEmpty(pageUrl)) {
//            return;
//        }
//
//        // step 2: page?p1=v1&p2=v2
//        String pageKey = "";
//        HashMap<String, String> paramsMap = null;
//        if (pageUrl.indexOf("?") > 0) {
//            pageKey = pageUrl.substring(0, pageUrl.lastIndexOf("?"));
//            paramsMap = getUrlParms(pageUrl);
//        } else {
//            pageKey = pageUrl;
//        }
//
//        // step 3:
//        Intent intent = null;
//        Logger.e(pageKey);
//        switch (pageKey) {
//            case "gczf"://跳转桂菜知否
//                intent = new Intent(context, GuiCaiActivity.class);
//                break;
//            case "yhys"://跳转优化营商
//                intent = new Intent(context, OptimizeBusinessActivity.class);
//                break;
//            case "zxzx"://跳转在线咨询
//                if (isLogin) {
//                    context.startActivity(new Intent(context, ConsultOnlineActivity.class));
//                } else {
//                    context.startActivity(new Intent(context, LoginActivity.class));
//                }
//                break;
//            case "jczl"://跳转基层治理
//                if (isLogin) {
//                    context.startActivity(new Intent(context, CaseListActivity.class));
//                } else {
//                    context.startActivity(new Intent(context, LoginActivity.class));
//                }
//                break;
//        }
//        if (paramsMap != null) {
//            SerializableHashMap myMap = new SerializableHashMap();
//            myMap.setMap(paramsMap);//将hashmap数据添加到封装的myMap中
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("paramsMap", myMap);
//            if (intent != null) {
//                intent.putExtras(bundle);
//            }
//        }
//
//        // step 4
//        if (intent != null) {
//            context.startActivity(intent);
//        }
    }

    /**
     * 处理url工具类
     */
    public static HashMap<String, String> getUrlParms(String url) {
        HashMap<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit = null;
        String strUrlParam = TruncateUrlPage(url);
        if (strUrlParam == null) {
            return mapRequest;
        }
        //每个键值为一组 www.2cto.com
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");

            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

    /**
     * 去掉url中的路径，留下请求参数部分
     *
     * @param strURL url地址
     * @return url请求参数部分
     */
    private static String TruncateUrlPage(String strURL) {
        String strAllParam = null;
        String[] arrSplit = null;

        strURL = strURL.trim();

        arrSplit = strURL.split("[?]");
        if (strURL.length() > 1) {
            if (arrSplit.length > 1) {
                if (arrSplit[1] != null) {
                    strAllParam = arrSplit[1];
                }
            }
        }

        return strAllParam;
    }

    /**
     * 去除文件名中的特殊字符
     */
    public static String StringFilter(String str) throws PatternSyntaxException {
// 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]";
// 清除掉所有特殊字符
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String trim = m.replaceAll("").trim();
        int fileNameLength;
        fileNameLength = trim.length() > 30 ? 30 : trim.length();//文件名长度不超过30个字符
        return trim.substring(0, fileNameLength);
    }

    /**
     * 去除文件名中的特殊字符和文字
     */
    public static String StringNumFilter(String str) throws PatternSyntaxException {
// 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]";
// 清除掉所有特殊字符
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？0123456789-]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String trim = m.replaceAll("").trim();
        int fileNameLength;
        fileNameLength = trim.length() > 30 ? 30 : trim.length();//文件名长度不超过30个字符
        return trim.substring(0, fileNameLength);
    }


    /**
     * 文件转base64字符串
     *
     * @param file
     * @return
     */
    public static String fileToBase64(File file) {
        String base64 = null;
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            int length = in.read(bytes);
            base64 = Base64.encodeToString(bytes, 0, length, Base64.DEFAULT);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return base64;
    }

    /**
     * pk参数，正式服为1，测试服为2，okgo的头和注册设备接口用到
     */
//    public static String getRegisterDevicePK() {
//        return BuildConfig.registerDevicePK;
//    }



    /**
     * 刷新媒体库（图片下载后需要刷新媒体库才能在相册显示）
     *
     * @param context
     * @param path
     */
    public static void updateMedia(final Context context, String path) {

        if (SDK_INT >= Build.VERSION_CODES.KITKAT) {//当大于等于Android 4.4时
            MediaScannerConnection.scanFile(context, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                @Override
                public void onScanCompleted(String path, Uri uri) {
                    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    mediaScanIntent.setData(uri);
                    context.sendBroadcast(mediaScanIntent);
                }
            });

        } else {//Andrtoid4.4以下版本
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.fromFile((new File(path).getParentFile()))));
        }

    }




}
