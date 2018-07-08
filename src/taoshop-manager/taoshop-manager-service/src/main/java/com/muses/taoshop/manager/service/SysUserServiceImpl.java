package com.muses.taoshop.manager.service;

import com.muses.taoshop.manager.mapper.SysUserMapper;
import com.muses.taoshop.manager.entity.SysUser;
import com.muses.taoshop.manager.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *  TODO 类说明
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.07.08 11:15    修改内容:
 * </pre>
 */
@Service
public class SysUserServiceImpl implements ISysUserService{

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser getSysUser(String username , String password) {
        return sysUserMapper.getSysUserInfo(username , password);
    }
}
