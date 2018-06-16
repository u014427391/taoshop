package com.muses.taoshop.item.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;

import com.muses.taoshop.item.dto.ItemBrand;

import java.util.List;

@MybatisRepository
public interface ItemBrandMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ItemBrand record);

    int insertSelective(ItemBrand record);

    ItemBrand selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") ItemBrand record, @Param("example") ItemBrandExample example);

//    int updateByExample(@Param("record") ItemBrand record, @Param("example") ItemBrandExample example);

    int updateByPrimaryKeySelective(ItemBrand record);

    int updateByPrimaryKey(ItemBrand record);

    List<ItemBrand> listItemBrand();
}