package com.muses.taoshop.item.mapper;

import com.muses.taoshop.item.entity.ItemSpec;
import com.muses.taoshop.item.entity.ItemSpecValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ItemSpecMapper {
    List<ItemSpec> getSpecBySpuId(@Param("spuId")int spuId);

    List<ItemSpecValue> getSpecValueBySkuId(@Param("skuId")int skuId);
}
