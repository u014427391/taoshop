package com.muses.taoshop.item.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.item.entity.ItemCategory;
import com.muses.taoshop.item.entity.dto.ItemCategoryDTO;

import java.util.List;

@MybatisRepository
public interface ItemCategoryMapper {

    List<ItemCategoryDTO> listRootCategory();

}