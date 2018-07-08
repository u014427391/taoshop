package com.muses.taoshop.manager.core;

import java.util.Locale;

/**
 * <pre>
 *  Constants类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.07.08 11:00    修改内容:
 * </pre>
 */
public class Constants {
    //定义统一Locale.CHINA,程序中所有和Locale相关操作均默认使用此Locale
    public static final Locale LOCALE_CHINA = Locale.CHINA;

    //验证码Session
    public static final String SESSION_SECURITY_CODE = "sessionSecCode";
    //用户信息Session
    public static final String SESSION_USER = "sessionUser";
    //角色权限Session
    public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
    //所有菜单Session
    public static final String SESSION_ALLMENU = "sessionAllMenu";
    //权限Session
    public static final String SESSION_RIGHTS = "sessionRights";

    //页面分页数量
    public static final Integer PAGE_SIZE = 6;
    //页面排序数量
    public static final Integer SORT_SIZE = 3;

    //登录URL
    public static final String URL_LOGIN = "/login.do";

    //登录过滤的正则表达式
    public static final String REGEXP_PATH = ".*/((login)|(logout)|(toblog)|(search)|(getArchiveArticles)|(code)|(plugins)|(upload)|(static)).*";	//不对匹配该值的访问路径拦截（正则）

    //Lucene索引的路径
    public static final String LUCENE_INDEX_PATH = "D:\\lucene";
}
