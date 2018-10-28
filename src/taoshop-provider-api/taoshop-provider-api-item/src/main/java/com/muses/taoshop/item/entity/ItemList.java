package com.muses.taoshop.item.entity;

import lombok.Data;

/**
 * <pre>
 *  商品信息Vo类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.10.27 23:46    修改内容:
 * </pre>
 */
@Data
public class ItemList {
    /**
     * spu id
     */
    private Long spuId;
    /**
     * 商品名称
     */
    private String itemName;

    /**
     * sku id
     */
    private Long skuId;
    /**
     * 商品价钱
     */
    private Long skuPrice;
    /**
     * 图片路径
     */
    private String imgPath;
}
