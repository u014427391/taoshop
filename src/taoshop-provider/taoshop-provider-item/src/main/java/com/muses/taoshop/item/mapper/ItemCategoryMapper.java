package com.muses.taoshop.item.mapper;

import com.muses.taoshop.item.entity.ItemCategory;
import com.muses.taoshop.item.entity.ItemList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ItemCategoryMapper {

    List<ItemCategory> listRootCategory();

    List<ItemCategory> listCategory();

    List<ItemList> listItemByCategoryId(@Param("categoryId") int categoryId);
}