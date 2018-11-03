package com.muses.taoshop.common.cas.constant;

/**
 * <pre>
 *  单点登录配置类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.10.28 22:40    修改内容:
 * </pre>
 */
public class CasConsts {
    //CAS server地址
    public static final String CAS_SERVER_URL_PREFIX = "http://127.0.0.1:8080/cas";

    //单点登录地址
    public static final String CAS_SERVER_LOGIN_URL = CAS_SERVER_URL_PREFIX + "/login";

    //单点登出地址
    public static final String CAS_SERVER_LOGOUT_URL = CAS_SERVER_LOGIN_URL + "/logout";

    //对外提供的服务地址
    public static final String SERVER_URL_PREFIX = "http://127.0.0.1:8080/";

    //casFilter utlPattern
    public static final String CAS_FILTER_URL_PATTERN = "/cas";

    //登录地址
    public static final String LOGIN_URL = CAS_SERVER_LOGIN_URL + "?server=" +SERVER_URL_PREFIX + CAS_FILTER_URL_PATTERN;

    //登出地址
    public static final String LOGOUT_URL = CAS_SERVER_LOGOUT_URL + "?server=" + SERVER_URL_PREFIX;

    //登录成功地址
    public static final String LOGIN_SUCCESS_URL = "/toIndex";

    //权限认证失败跳转地址
    public static final String UNUATHORIZED_URL = "/error/403.html";

}

