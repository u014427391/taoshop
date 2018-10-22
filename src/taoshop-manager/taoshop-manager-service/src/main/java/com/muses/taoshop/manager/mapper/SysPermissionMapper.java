package com.muses.taoshop.manager.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.manager.entity.Permission;

import java.util.List;

@MybatisRepository
public interface SysPermissionMapper {
    List<Permission> listRolePermission(int roleId);
}
