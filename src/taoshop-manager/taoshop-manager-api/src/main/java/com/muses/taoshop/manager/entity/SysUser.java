package com.muses.taoshop.manager.entity;

import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * <pre>
 *  系统用户
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.07.01 18:51    修改内容:
 * </pre>
 */
@Data
public class SysUser {

    /**
     *  用户id
     */
    private int id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String mark;

    /**
     * 用户级别
     */
    private String rank;

    /**
     * 上次登录时间
     */
    private Date lastLogin;

    /**
     * 登录的IP地址
     */
    private String loginIp;

    /**
     * 头像图片地址
     */
    private String imageUrl;

    /**
     * 注册时间
     */
    private Date regTime;

    /**
     *  账号是否被锁定
     */
    private Boolean locked = Boolean.FALSE;

    /**
     * 权限
     */
    private String rights;

    private Set<SysRole> roles;


}
