package com.muses.taoshop.item.service;

import com.muses.taoshop.item.entity.ItemSpec;
import com.muses.taoshop.item.entity.ItemSpecValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IItemSpecService {
    /**
     * 获取spuId获取规格参数列表
     * @return
     */
    List<ItemSpec> getSpecBySpuId(int spuId);

    /**
     * 通过SkuId获取规格参数Value列表
     * @param skuId
     * @return
     */
    List<ItemSpecValue> getSpecValueBySkuId(int skuId);
}
