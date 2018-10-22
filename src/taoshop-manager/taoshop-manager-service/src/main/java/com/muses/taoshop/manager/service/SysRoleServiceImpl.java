package com.muses.taoshop.manager.service;

import com.muses.taoshop.manager.entity.SysRole;
import com.muses.taoshop.manager.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 *  角色业务类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.10.21 21:59    修改内容:
 * </pre>
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    /**
     * 通过用户id获取用户角色
     *
     * @param userId
     * @return
     */
    @Override
    public Set<SysRole> getUserRoles(int userId) {
        List<SysRole> roleList = sysRoleMapper.listUserRole(userId);
        Set<SysRole> roles = new HashSet<>(roleList);
        return roles;
    }
}
