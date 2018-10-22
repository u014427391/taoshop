package com.muses.taoshop.manager.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.manager.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <pre>
 *  菜单管理
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.09.22 12:33    修改内容:
 * </pre>
 */
@MybatisRepository
public interface SysMenuMapper {

    Menu listMenu(@Param("permissionId") int permissionId);

    List<Menu> listPermissionMenu(@Param("userId")int userId);
}
