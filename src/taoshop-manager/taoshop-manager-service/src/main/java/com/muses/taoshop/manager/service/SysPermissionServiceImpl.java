package com.muses.taoshop.manager.service;

import com.muses.taoshop.manager.entity.Permission;
import com.muses.taoshop.manager.mapper.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 *  权限业务接口
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.10.21 23:34    修改内容:
 * </pre>
 */
@Service
public class SysPermissionServiceImpl implements ISysPermissionService{

    @Autowired
    SysPermissionMapper sysPermissionMapper;

    @Override
    public Set<Permission> getRolePermissions(int roleId) {
        List<Permission> permissionList = sysPermissionMapper.listRolePermission(roleId);
        Set<Permission> permissions = new HashSet<Permission>(permissionList);
        return permissions;
    }
}
