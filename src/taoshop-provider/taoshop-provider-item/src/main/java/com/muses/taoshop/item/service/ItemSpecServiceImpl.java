package com.muses.taoshop.item.service;

import com.muses.taoshop.item.entity.ItemSpec;
import com.muses.taoshop.item.entity.ItemSpecValue;
import com.muses.taoshop.item.mapper.ItemSpecMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemSpecServiceImpl implements IItemSpecService {

    @Autowired
    ItemSpecMapper itemSpecMapper;

    /**
     * 获取spuId获取规格参数列表
     * @param spuId
     * @return
     */
    @Override
    public List<ItemSpec> getSpecBySpuId(int spuId) {
        return itemSpecMapper.getSpecBySpuId(spuId);
    }

    /**
     * 通过SkuId获取规格参数Value列表
     *
     * @param skuId
     * @return
     */
    @Override
    public List<ItemSpecValue> getSpecValueBySkuId(int skuId) {
        return itemSpecMapper.getSpecValueBySkuId(skuId);
    }
}
