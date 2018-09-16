package com.muses.taoshop.item.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <pre>
 *  定义一个在门户网站显示商品信息的VO类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.30 17:17    修改内容:
 * </pre>
 */
@Data
public class ItemPortal {

    /**
     * skuId
     */
    private int skuId;

    /**
     * spuId
     */
    private int spuId;

    /**
     * sku的最低售价
     */
    private long mPrice;

    /**
     * 产品名称
     */
    private String itemName ;

    /**
     * 图片路径
     */
    private String imgPath;

}
