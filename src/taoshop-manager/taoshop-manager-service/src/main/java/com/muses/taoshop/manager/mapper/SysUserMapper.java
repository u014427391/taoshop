package com.muses.taoshop.manager.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.manager.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * <pre>
 *
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.07.08 11:17    修改内容:
 * </pre>
 */
@MybatisRepository
public interface SysUserMapper {
    SysUser getSysUserInfo(@Param("username")String username, @Param("password")String password);
}
