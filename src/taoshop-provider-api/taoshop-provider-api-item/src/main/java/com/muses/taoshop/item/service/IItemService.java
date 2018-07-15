package com.muses.taoshop.item.service;

import com.muses.taoshop.item.entity.ItemDetail;
import com.muses.taoshop.item.entity.ItemPortal;

import java.util.List;

/**
 * <pre>
 *  商品信息服务接口
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.24 22:34    修改内容:
 * </pre>
 */
public interface IItemService {
    /**
     * 在门户网站列出商品粗略信息
     * @return
     */
    List<ItemPortal> listItemPortal();

    /**
     * 获取商品详情信息
     * @return ItemDetail
     */
    ItemDetail getItemDetailInfo(int spuId);
}
