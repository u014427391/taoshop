package com.muses.taoshop.user.entity;

import lombok.Data;

/**
 * <pre>
 *  商城用户信息VO类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.08.05 15:24    修改内容:
 * </pre>
 */
@Data
public class User {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
