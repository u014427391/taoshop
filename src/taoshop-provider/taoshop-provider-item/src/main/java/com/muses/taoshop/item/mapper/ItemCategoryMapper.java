package com.muses.taoshop.item.mapper;

import com.muses.taoshop.item.entity.ItemCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ItemCategoryMapper {

    List<ItemCategory> listRootCategory();

    List<ItemCategory> listCategory();
}