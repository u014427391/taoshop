package com.muses.taoshop.item.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Setter
@Getter
@ToString
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


}