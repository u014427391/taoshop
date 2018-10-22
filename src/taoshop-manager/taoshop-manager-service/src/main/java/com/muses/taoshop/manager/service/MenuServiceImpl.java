package com.muses.taoshop.manager.service;

import com.muses.taoshop.manager.entity.Menu;
import com.muses.taoshop.manager.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *  菜单管理业务接口
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.09.22 12:34    修改内容:
 * </pre>
 */
@Service
public class MenuServiceImpl implements IMenuService{

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public Menu listMenu(int permissionId) {
        return sysMenuMapper.listMenu(permissionId);
    }
}
