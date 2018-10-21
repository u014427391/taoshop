package com.muses.taoshop.manager.service;


import com.muses.taoshop.manager.entity.Permission;

import java.util.List;
import java.util.Set;

public interface ISysPermissionService {
    /**
     * 获取角色所有权限
     * @return
     */
    Set<Permission> getRolePermissions(int roleId);
}
