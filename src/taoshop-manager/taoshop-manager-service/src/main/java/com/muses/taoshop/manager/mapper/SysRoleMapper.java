package com.muses.taoshop.manager.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.manager.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <pre>
 *  角色操作Mapper接口
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.10.21 21:55    修改内容:
 * </pre>
 */
@MybatisRepository
public interface SysRoleMapper {

    List<SysRole> listUserRole(@Param("userId")int userId);

}
