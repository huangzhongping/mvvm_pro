/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:CommonUtils.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.ericcui.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author allen
 * @ClassName: CommonUtils
 * @Description: 公共的工具类
 * @date 2012-11-1 下午3:15:52
 */
public class CommonUtils {

    public static Toast mToast;
    public static void showLongToast(Context context,String content){
        if(mToast==null){
            mToast=Toast.makeText(context,content,Toast.LENGTH_LONG);
        }else {
            mToast.setText(content);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }
    public static void showShortToast(Context context,String content){
        if(mToast==null){
            mToast=Toast.makeText(context,content,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(content);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
    /**
     * 显示Toast 消息提示
     *
     * @param msg
     */
    public static void showToast(String msg) {
        try {
            CommonUtils.showToast(msg, Toast.LENGTH_SHORT);
        } catch (Exception e) {

        }
    }

    /**
     * @param msg      提示消息
     * @param duration 提示的时间
     * @Title: showToast
     * @Description: 显示Toast提示
     * @returnType void
     */
    public static void showToast(String msg, int duration) {
        try {
            Toast.makeText(Utils.getContext(), msg, duration).show();
        } catch (Exception e) {

        }
    }

    /**
     * @param titleName 字体
     * @param textsize  字体大小
     * @return
     */
    public static SpannableString getSpannableTabString(String titleName, float textsize) {
        if (titleName == null) return null;
        SpannableString spannableString = new SpannableString(titleName);
        spannableString.setSpan(new AbsoluteSizeSpan((int) textsize), 0, titleName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }


    /**
     * @param titleName 字体
     * @return drawable 图片
     */
    public static SpannableString getSpannableImageString(String titleName, Drawable drawable) {
        if (titleName == null) return null;
        titleName = "[smile]" + titleName;
        SpannableString spannableString = new SpannableString(titleName);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());//这里设置图片的大小
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        spannableString.setSpan(imageSpan, 0,
                "[smile]".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }


    /**
     * 判断字符串是否数值
     *
     * @param str
     * @return true:是数值 ；false：不是数值
     */
    public static boolean isPhoneNumber(String str) {
//        if(!StringUtil.isEmpty(str)){
//            if(str.trim().length()==11){
//                return true;
//            }
//        }
//        return false;

        Pattern pattern = Pattern.compile("[0-9]{11,11}");
        Matcher match = pattern.matcher((str));
        return match.matches();
//        Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0,6,7,8])|(14[5,7]))\\d{8}$");
//        Matcher match = pattern.matcher(str);
//        return match.matches();
    }


    /**
     * 匹配邮箱
     *
     * @param str
     * @return
     */
    public static boolean isEmailNumber(String str) {
        Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
        Matcher match = pattern.matcher(str);
        return match.matches();
    }


    /**
     * 匹配护照
     *
     * @param id
     * @return
     */
    public static boolean isPassportId(String id) {
//        Pattern pattern = Pattern.compile("(^1[4-5]{1}[0-9]{7}$)|^[a-zA-Z]{1}[0-9]{8}$");
//        Matcher match = pattern.matcher(id);
//        return match.matches();
        return true;
    }

    /**
     * 通行证
     *
     * @param id
     * @return
     */
    public static Boolean IsSafeConduct(String id) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{1}[0-9]{8}$");
        Matcher match = pattern.matcher(id);
        return match.matches();
    }

    /**
     * 回乡证
     *
     * @param id
     * @return
     */
    public static Boolean IsReturnBackConduct(String id) {
        Pattern pattern = Pattern.compile("^[A-Za-z]{1}\\d{6}[\\(|（)]\\d{1}[\\)|）]$");
        Matcher match = pattern.matcher(id);
        return match.matches();
    }

    /**
     * 台胞证
     *
     * @param id
     * @return
     */
    public static Boolean IsTaiwanConduct(String id) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{1}[0-9]{9}$");
        Matcher match = pattern.matcher(id);
        return match.matches();
    }

    /**
     * 警官证
     *
     * @param id
     * @return
     */
    public static boolean isPoliceCard(String id) {
        Pattern pattern = Pattern.compile("[0-9]\\d{5}(?!\\d)");
        Matcher match = pattern.matcher(id);
        return match.matches();
    }

    /**
     * 士兵证
     *
     * @param id
     * @return
     */
    public static boolean isSoldierCard(String id) {
        Pattern pattern = Pattern.compile("[0-9]\\d{6}(?!\\d)");
        Matcher match = pattern.matcher(id);
        return match.matches();
    }


    /**
     * 军官证
     *
     * @param id
     * @return
     */
    public static boolean isOfficerCard(String id) {
        Pattern pattern = Pattern.compile("[0-9]\\d{7}(?!\\d)");
        Matcher match = pattern.matcher(id);
        return match.matches();
    }

    /**
     * 解决ScollView中嵌套ListView的情况
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        //获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {   //listAdapter.get
            // Count()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);  //计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight();  //统计所有子项的总高度

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        //listView.getDividerHeight()获取子项间分隔符占用的高度
        //params.height最后得到整个ListView完整显示需要的高度

        listView.setLayoutParams(params);
    }


    //生成随机字符串
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取渠道ID
     *
     * @return
     */
    public static String getUmengChannel() {
        ApplicationInfo ai = null;
        String channel = "其他";
        try {
            ai = Utils.getContext().getPackageManager().getApplicationInfo(Utils.getContext().getPackageName(),
                    PackageManager.GET_META_DATA);
            channel = "" + ai.metaData.get("UMENG_CHANNEL");
        } catch (Exception e) {
//            MLog.e(e.toString());
        }
        return channel;
    }
    /**
     * dp转px
     *
     * @param context context
     * @param dpValue dp
     * @return px
     */
    public static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
