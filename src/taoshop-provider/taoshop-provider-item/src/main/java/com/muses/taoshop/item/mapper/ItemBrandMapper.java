package com.muses.taoshop.item.mapper;


import com.muses.taoshop.item.entity.ItemBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemBrandMapper {
    List<ItemBrand> listItemBrand();

}