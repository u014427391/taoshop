package com.muses.taoshop.manager.entity;

import lombok.Data;

import java.util.List;

/**
 * <pre>
 *  菜单信息实体类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.09.22 12:32    修改内容:
 * </pre>
 */
@Data
public class Menu {
    /**
     * 菜单Id
     **
     */
    private int menuId;

    /**
     * 上级Id
     *
     */
    private int parentId;

    /**
     * 菜单名称
     *
     */
    private String menuName;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单uri
     */
    private String menuUrl;

    /**
     * 菜单类型
     */
    private String menuType;

    /** 菜单排序**/
    private String menuOrder;

    /**
     * 菜单排序
     */
    private String menuStatus;

    /**
     * 子级菜单
     */
    private List<Menu> subMenu;

    private String target;

    /**
     * 是否有子级菜单
     */
    private boolean hasSubMenu = false;
}
