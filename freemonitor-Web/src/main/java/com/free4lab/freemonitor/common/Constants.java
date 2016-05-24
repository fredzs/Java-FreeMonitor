package com.free4lab.freemonitor.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public final class Constants {

	/**
     * 上传文件大小限制
     */
    public final static int MAX_FILE_LENGTH_MB;
    public final static int MAX_FILE_LENGTH_B;
    /**
     * Session中存用户权限信息的键值
     */
    public final static String USER_ID_KEY = "userId";
    public final static String USER_NAME_KEY = "userName";
    public final static String USER_INT_ID_KEY = "userIntId";
    public final static String USER_EMAIL_KEY = "userEmail";
    public final static String USER_AVATAR_KEY = "avatar";
    public final static String ACCESSTOKEN = "accessToken";
    
    /**
     * FreeShare根群组的uuid和authtoken信息
     */
    public final static String FREE_SHARE_UUID;
    public final static String FREE_SHARE_AUTOKEN;
   
    /**
     * 统一认证相关信息
     */
    public final static String USER_INFO_API;//Free Account获取用户信息的api地址
    public final static String ACCESS_TOKEN_URL;//Free Account获取accessToken的api地址
    public final static String LOGIN_URL;//Free Account 登录操作地址
    public final static String FREE_ACCOUNT_APP_KEY;//Free group在Free Account的客户标识
    public final static String API_ARG_NAME;//参数名
    public final static int MAX_FREEACCOUNT_ATTEMPTS;//最大尝试次数
    public final static String ACCESS_TOKEN_KEY;//accessToken参数名
    public final static String BILLING_SERVER_URL;//账户信息服务器
    public final static String PLATFORM_EMAIL;//平台进账邮箱

    public final static String CSS_JS_SERVER;//CSS JS库
    public final static String CHA_PSW_URL;//account 修改密码链接
    
    public final static String DEFAULT_AVATAR;
    
    static {
        final Logger logger = Logger.getLogger("App configuration");
        logger.info("+++++++++++App configuration information++++++++++++");
        try {
            Properties p = new ConfigurationUtil().getPropertyFileConfiguration("app.properties");

            MAX_FILE_LENGTH_MB = Integer.parseInt(p.getProperty("MAX_FILE_LENGTH_MB"));
            logger.info("MAX_FILE_LENGTH_MB:" + MAX_FILE_LENGTH_MB);
            MAX_FILE_LENGTH_B = MAX_FILE_LENGTH_MB * 1024 * 1024;
            
            USER_INFO_API = p.getProperty("USER_INFO_API");
            logger.info("USER_INFO_API:" + USER_INFO_API);
            
            ACCESS_TOKEN_URL = p.getProperty("ACCESS_TOKEN_URL");
            logger.info("ACCESS_TOKEN_URL:" + ACCESS_TOKEN_URL);
            
            LOGIN_URL = p.getProperty("LOGIN_URL");
            logger.info("LOGIN_URL:" + LOGIN_URL);
            
            FREE_ACCOUNT_APP_KEY = p.getProperty("FREE_ACCOUNT_APP_KEY");
            logger.info("FREE_ACCOUNT_APP_KEY:" + FREE_ACCOUNT_APP_KEY);
            
            API_ARG_NAME = p.getProperty("API_ARG_NAME");
            logger.info("API_ARG_NAME:" + API_ARG_NAME);
            
            MAX_FREEACCOUNT_ATTEMPTS = Integer.parseInt(p.getProperty("MAX_FREEACCOUNT_ATTEMPTS"));
            logger.info("MAX_FREEACCOUNT_ATTEMPTS:" + MAX_FREEACCOUNT_ATTEMPTS);
            
            ACCESS_TOKEN_KEY = p.getProperty("ACCESS_TOKEN_KEY");
            logger.info("ACCESS_TOKEN_KEY:" + ACCESS_TOKEN_KEY);
            
            PLATFORM_EMAIL = p.getProperty("PLATFORM_EMAIL");
            logger.info("PLATFORM_EMAIL:" + PLATFORM_EMAIL);
            
            CSS_JS_SERVER = p.getProperty("CSS_JS_SERVER");
            logger.info("CSS_JS_SERVER:" + CSS_JS_SERVER);
            
            CHA_PSW_URL = p.getProperty("CHA_PSW_URL");
            logger.info("CHA_PSW_URL:" + CHA_PSW_URL);
            
            FREE_SHARE_UUID = p.getProperty("FREE_SHARE_UUID");
            logger.info("FREE_SHARE_UUID:" + FREE_SHARE_UUID);
            FREE_SHARE_AUTOKEN = p.getProperty("FREE_SHARE_AUTOKEN");
            logger.info("FREE_SHARE_AUTOKEN:" + FREE_SHARE_AUTOKEN);
            
            BILLING_SERVER_URL = p.getProperty("BILLING_SERVER_URL");
            logger.info("BILLING_SERVER_URL:" + BILLING_SERVER_URL);
            
            DEFAULT_AVATAR = p.getProperty("DEFAULT_AVATAR");
            logger.info("DEFAULT_AVATAR:" + DEFAULT_AVATAR);
            
            
        } catch (IOException e) {
            logger.fatal("Failed to init app configuration", e);
            throw new RuntimeException("Failed to init app configuration", e);
        }
        logger.info("----------App configuration successfully----------");
    }
}
