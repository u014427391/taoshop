package com.muses.taoshop.manager.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *  角色信息实体类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.09.22 13:31    修改内容:
 * </pre>
 */
@Data
public class SysRole {
    /** 角色Id**/
    private int roleId;

    /** 角色描述**/
    private String roleDesc;

    /** 角色名称**/
    private String roleName;

    /** 角色标志**/
    private String role;

    private Set<Permission> permissions = new HashSet<Permission>();
}
