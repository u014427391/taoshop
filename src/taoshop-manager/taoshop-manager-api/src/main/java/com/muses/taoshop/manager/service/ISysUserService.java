package com.muses.taoshop.manager.service;

import com.muses.taoshop.manager.entity.SysUser;

/**
 * <pre>
 *  TODO 类说明
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
    SysUser getSysUser(String username , String password);
}
