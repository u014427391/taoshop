package com.muses.taoshop.item.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Setter
@Getter
@ToString
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

}