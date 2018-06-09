package com.muses.taoshop.vo;

import java.util.Date;

/**
 * <pre>
 *  商品品牌VO类
 * </pre>
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.09 21:49    修改内容:
 * </pre>
 */
public class ItemBrand {
    /**
     * 品牌id
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 上次修改时间
     */
    private Date lastModifyTime;

    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
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
}