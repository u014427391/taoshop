package com.muses.taoshop.item.entity;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 *  商品品类
 * </pre>
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.09 21:49    修改内容:
 * </pre>
 */
public class ItemCategory {
    /**
     * 商品品类id
     */
    private Long id;

    /**
     * 商品品类名称
     */
    private String categoryName;

    /**
     * 上级id
     */
    private Long sjid;

    /**
     * 上次修改时间
     */
    private Date lastModifyTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 子菜单
     */
    private List<ItemCategory> subCategorys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Long getSjid() {
        return sjid;
    }

    public void setSjid(Long sjid) {
        this.sjid = sjid;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ItemCategory> getSubCategorys() {
        return subCategorys;
    }

    public void setSubCategorys(List<ItemCategory> subCategorys) {
        this.subCategorys = subCategorys;
    }
}