package com.muses.taoshop.item.service;

import com.muses.taoshop.item.entity.ItemBrand;

import java.util.List;

/**
 * <pre>
 *  商品品牌服务类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.15 22:56    修改内容:
 * </pre>
 */
public interface IItemBrankService {
    /**
     * 查询所有的商品品牌信息
     * @return
     */
    List<ItemBrand> listItemBrand();
}
