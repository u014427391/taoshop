package com.muses.taoshop.item.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import java.util.List;

import com.muses.taoshop.item.entity.ItemSkuSpecValue;
import org.apache.ibatis.annotations.Param;

@MybatisRepository
public interface ItemSkuSpecValueMapper {
    int countByExample(ItemSkuSpecValue example);

    int deleteByExample(ItemSkuSpecValue example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemSkuSpecValue record);

    int insertSelective(ItemSkuSpecValue record);

    List<ItemSkuSpecValue> selectByExample(ItemSkuSpecValue example);

    ItemSkuSpecValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemSkuSpecValue record, @Param("example") ItemSkuSpecValue example);

    int updateByExample(@Param("record") ItemSkuSpecValue record, @Param("example") ItemSkuSpecValue example);

    int updateByPrimaryKeySelective(ItemSkuSpecValue record);

    int updateByPrimaryKey(ItemSkuSpecValue record);
}