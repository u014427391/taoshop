package com.muses.taoshop.item.service;

import com.muses.taoshop.item.entity.ItemSpec;
import com.muses.taoshop.item.entity.ItemSpecValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <pre>
 *  TODO 类说明
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.07.28 16:18    修改内容:
 * </pre>
 */
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
