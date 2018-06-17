package com.muses.taoshop.item.service;

import com.muses.taoshop.item.entity.ItemBrand;
import com.muses.taoshop.item.mapper.ItemBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *  商品品牌信息服务实现类
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.15 22:54    修改内容:
 * </pre>
 */
@Service
public class ItemBrankServiceImpl implements IItemBrankService{

    @Autowired
    ItemBrandMapper itemBrandMapper;

    @Override
    public List<ItemBrand> listItemBrand() {
        return itemBrandMapper.listItemBrand();
    }



}
