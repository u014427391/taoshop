package com.muses.taoshop.item.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.item.entity.ItemSku;

@MybatisRepository
public interface ItemSkuMapper {


    int deleteByPrimaryKey(Long id);

    int insert(ItemSku record);

    int insertSelective(ItemSku record);



    ItemSku selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") ItemSku record, @Param("example") ItemSkuExample example);
//
//    int updateByExample(@Param("record") ItemSku record, @Param("example") ItemSkuExample example);

    int updateByPrimaryKeySelective(ItemSku record);

    int updateByPrimaryKey(ItemSku record);
}