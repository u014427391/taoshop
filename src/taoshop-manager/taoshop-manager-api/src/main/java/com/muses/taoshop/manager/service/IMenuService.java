package com.muses.taoshop.manager.service;


import com.muses.taoshop.manager.entity.Menu;

import java.util.List;

public interface IMenuService {
    /**
     * 根据权限id获取菜单
     * @param permissionId
     * @return
     */
    Menu listMenu(int permissionId);

    /**
     * 权限菜单获取，即根据用户角色获取用户可以查看的菜单
     * @return
     */
    List<Menu> listPermissionMenu(int userId);
}
