package com.muses.taoshop.item.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
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
@MybatisRepository
public interface ItemSpecMapper {
    List<ItemSpec> getSpecBySpuId(@Param("spuId")int spuId);

    List<ItemSpecValue> getSpecValueBySkuId(@Param("skuId")int skuId);
}
