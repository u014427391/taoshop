package com.muses.taoshop.item.entity;

import java.util.Date;

/**
 * <pre>
 *  商品SKU规格值VO类
 * </pre>
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.09 21:49    修改内容:
 * </pre>
 */
public class ItemSkuSpecValue {
    /**
     * id
     */
    private Long id;
    /**
     * spu id
     */
    private Long spuId;
    /**
     * 规格值id
     */
    private Long specValueId;
    /**
     * 上一次修改时间
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

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSpecValueId() {
        return specValueId;
    }

    public void setSpecValueId(Long specValueId) {
        this.specValueId = specValueId;
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