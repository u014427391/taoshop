package com.muses.taoshop.item.service;

import com.muses.taoshop.item.entity.ItemCategory;
import com.muses.taoshop.item.entity.ItemDto;
import com.muses.taoshop.item.entity.ItemVo;

import java.util.List;

/**
 * <pre>
 *  商品品类信息接口
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.17 10:59    修改内容:
 * </pre>
 */
public interface IItemCategoryService {
    /**
     * 查询根级商品品类信息
     * @return
     */
    List<ItemCategory> listRootCategory();

    /**
     * 查询所有商品品类信息
     * @return
     */
    List<ItemCategory> listCategory();

    /**
     * 根据品目id获取商品信息
     * @return
     */
    List<ItemVo> listItemByCategoryId(int categoryId);
}
