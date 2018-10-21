package com.muses.taoshop.manager.service;

import com.muses.taoshop.manager.entity.Operation;
import com.muses.taoshop.manager.entity.Permission;
import com.muses.taoshop.manager.entity.SysRole;
import com.muses.taoshop.manager.mapper.SysRoleMapper;
import com.muses.taoshop.manager.mapper.SysUserMapper;
import com.muses.taoshop.manager.entity.SysUser;
import com.muses.taoshop.manager.service.ISysUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 *  用户信息管理业务类
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
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public SysUser getSysUser(String username , String password) {
        return sysUserMapper.getSysUserInfo(username , password);
    }

    /**
     * 获取用户角色
     * @param username
     * @return
     */
    @Override
    public Set<String> getRoles(String username) {
        SysUser user = this.getUserInfoByUsername(username);
        Set<SysRole> roles = user.getRoles();
        Set<String>  roleStrs = new HashSet<String>();
        for(SysRole r : roles){
            roleStrs.add(r.getRole());
        }
        return roleStrs;
    }

    /**
     * 通过用户id获取用户角色集合
     * @param userId
     * @return
     */
    @Override
    public Set<SysRole> getUserRoles(int userId) {
        List<SysRole> roleList = sysRoleMapper.listUserRole(userId);
        Set<SysRole> roles = new HashSet<>(roleList);
        return roles;
    }

    /**
     * 获取用户权限
     * @param username
     * @return
     */
    public Set<String> getPermissions(String username) {
        SysUser user = this.getUserInfoByUsername(username);
        Set<SysRole> roles = user.getRoles();
        /* 创建一个HashSet来存放角色权限信息 */
        Set<String> permissions = new HashSet<String>();
        for(SysRole r : roles) {
            for (Permission p : r.getPermissions()){
                for(Operation o : p.getOperations()){
                    permissions.add(o.getOperation());
                }
            }
        }
        return permissions;
    }

    /**
     * 通过用户名获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public SysUser getUserInfoByUsername(String username) {
        return sysUserMapper.getUserInfoByUsername(username);
    }
}
