package com.muses.taoshop.manager.entity;

import lombok.Data;

/**
 * <pre>
 *  Operation类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.09.22 15:25    修改内容:
 * </pre>
 */
@Data
public class Operation {
    private int id;
    private String desc;
    private String name;
    private String operation;
    private static final long serialVersionUID = 1L;
}
