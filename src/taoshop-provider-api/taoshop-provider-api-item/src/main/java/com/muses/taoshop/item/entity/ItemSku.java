package com.muses.taoshop.item.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
/**
 * <pre>
 *  商品SKU类
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
public class ItemSku {
    /**
     *  id
     */
    private Long id;
    /**
     *  sku编码
     */
    private String skuCode;
    /**
     * sku名称
     */
    private String skuName;
    /**
     * 价钱
     */
    private BigDecimal price;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * spu id
     */
    private Long spuId;
    /**
     * 上一次修改时间
     */
    private Date lastModifyTime;
    /**
     * 创建时间
     */
    private Date createTime;


}