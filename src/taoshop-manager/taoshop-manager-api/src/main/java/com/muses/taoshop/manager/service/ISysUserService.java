package com.muses.taoshop.manager.service;

import com.muses.taoshop.manager.entity.SysUser;

import java.util.Set;

/**
 * <pre>
 *  系统用户信息处理接口类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.07.01 19:09    修改内容:
 * </pre>
 */
public interface ISysUserService {
    /**
     * 通过用户名和密码获取用户信息
     * @param username
     * @param password
     * @return
     */
    SysUser getSysUser(String username , String password);

    /**
     * 获取用户角色
     * @param username
     * @return
     */
    Set<String> getRoles(String username) ;

    /**
     * 获取用户权限
     * @param username
     * @return
     */
    Set<String> getPermissions(String username);

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    SysUser getUserInfoByUsername(String username);
}
