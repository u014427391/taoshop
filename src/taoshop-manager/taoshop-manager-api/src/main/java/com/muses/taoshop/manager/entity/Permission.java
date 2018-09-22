package com.muses.taoshop.manager.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *  权限信息实体类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.09.22 14:28    修改内容:
 * </pre>
 */
@Data
public class Permission {
    private int id;
    private String pdesc;
    private String name;

    private Menu menu;

    private Set<Operation> operations = new HashSet<Operation>();
}
