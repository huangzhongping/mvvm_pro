/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:EnumKey.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.example.networkrequest.cache;

/**
 * 作者：
 * 主要功能:用于注册全局监听的key，传值的对应的KEY
 * 创建时间：2016/1/4 16:46
 */
public class EnumKey {


    /**
     * 用于应用ACache缓存KEY
     */
    public class User {
        public static final String USER_NAME = "user_name"; //
        public static final String USER_TOKEN = "login_token"; //登录返回的token
        public static final String USER_REFRESH_TOKEN = "refresh_token"; //登录返回的token
        public static final String USER_TOKEN_EXPIRES = "token_expires"; //登录返回的token
        public static final String IS_SUPER_ADMIN = "is_super_admin"; //登录返回的company_id
        public static final String GUIDE_COMPLETE = "guide_complete"; //登录返回的company_id
        public static final String COMPANY_ID = "company_id"; //登录返回的company_id
        public static final String COMPANY_NAME = "company_name"; //登录返回的company_id
        public static final String EMPLOYEE_ID = "employee_id"; //
        public static final String DISPLAY_NAME = "display_name"; //
        public static final String FLOW_ID = "flow_id"; //登录返回的employee_id
        public static final String GUIDE_MAIN_COMPLETE = "guide_main_complete"; //登录返回的company_id
        public static final String GUIDE_ORGANIZATION_COMPLETE = "guide_organization_complete"; //登录返回的company_id
        public static final String DEVICE_ID = "device_id"; //阿里云deviceid
        public static final String REFRESH_TOKEN = "refresh_token";
        public static final String CURRENT_LANGUAGE = "current_language";//当前语言
        public static final String CLOCK_LIST = "CLOCK_LIST";//打卡队列


    }

    public class Employee {
        public static final String EMPLOYEE_CRUMB = "employee_crumb";
    }


    /**
     * 用于应用ACache缓存KEY
     */
    public class UmengAliasType {

        public static final String OFFICIAL = ""; //

    }

    /**
     * 用于应用ACache缓存KEY
     */
    public class ACacheKey {
        public static final String BUREAU_CITY = "bureauCity"; //当前城市
        public static final String LOGIN_INFO = "LoginInfo"; //保存登录账号信息KEY
        public static final String NO_MEMBER_LOGIN_INFO = "noMemberLoginInfo"; //非会员登录
        public static final String SCREENSHOTS_UNDER = "screenshots_under"; //截屏 下部分
        public static final String SCREENSHOTS_NO = "screenshots_no"; //截屏 上部分
        public static final String HISTORY_CACHE_CITY = "history_cache_city"; //搜索条件缓存
        public static final String KEYWORD_CACHE = "keyword_cache"; //搜索关键词缓存
        public static final String KEYWORD_APP_LAUNCHED = "keyword_app_launched"; //APP打开过

        public static final String USER_NAME = "user_name";
        public static final String USER_COMPANY = "user_company";
        public static final String USER_PHONE = "user_phone";
        public static final String USER_EMAIL = "user_email";
        public static final String APP_VERSION_CODE = "app_version_code";
        public static final String QINIU_TOKEN = "qiniu_token";
        public static final String BADGE_COUNT = "BADGE_COUNT";//badge红点数量


    }
}
