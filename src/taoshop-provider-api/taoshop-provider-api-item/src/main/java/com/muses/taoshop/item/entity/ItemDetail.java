package com.muses.taoshop.item.entity;

import lombok.Data;

/**
 * <pre>
 *  商品详情DTO类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.07.15 16:16    修改内容:
 * </pre>
 */
@Data
public class ItemDetail {
    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 商城售价
     */
    private long price;

    /**
     * 促销售价
     */
    private long promotionPrice;
}
