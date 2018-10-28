package com.muses.taoshop.common.security.core.constant;

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
    public static final String CAS_SERVER_URL_PREFIX = "http://127.0.0.1:8443/cas";

    //单点登录地址
    public static final String CAS_SERVER_LOGIN_URL = CAS_SERVER_URL_PREFIX + "/login";

    //单点登出地址
    public static final String CAS_SERVER_LOGOUT_URL = CAS_SERVER_LOGIN_URL + "/logout";

    //登录地址
    public static final String loginUrl = CAS_SERVER_LOGIN_URL + "?service=" ;

}
