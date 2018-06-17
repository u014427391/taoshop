package com.muses.taoshop.item.service;

import com.muses.taoshop.item.entity.ItemCategory;
import com.muses.taoshop.item.entity.dto.ItemCategoryDTO;
import com.muses.taoshop.item.mapper.ItemCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *  商品品类信息服务实现类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.17 11:01    修改内容:
 * </pre>
 */
@Service
public class ItemCategoryServiceImpl implements IItemCategoryService{

    @Autowired
    ItemCategoryMapper itemCategoryMapper;

    /**
     * 查询跟级商品品类信息
     *
     * @return
     */
    @Override
    public List<ItemCategoryDTO> listCategory() {
        return itemCategoryMapper.listRootCategory();
    }
}
