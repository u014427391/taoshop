package com.muses.taoshop.item.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.item.dto.ItemCategory;

@MybatisRepository
public interface ItemCategoryRepository {

    int deleteByPrimaryKey(Long id);

    int insert(ItemCategory record);

    int insertSelective(ItemCategory record);

//    List<ItemCategory> selectByExample(ItemCategoryExample example);

    ItemCategory selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") ItemCategory record, @Param("example") ItemCategoryExample example);

//    int updateByExample(@Param("record") ItemCategory record, @Param("example") ItemCategoryExample example);

    int updateByPrimaryKeySelective(ItemCategory record);

    int updateByPrimaryKey(ItemCategory record);
}