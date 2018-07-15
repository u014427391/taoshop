package com.muses.taoshop.item.mapper;


import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.item.entity.ItemDetail;
import com.muses.taoshop.item.entity.ItemPortal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MybatisRepository
public interface ItemMapper {

    List<ItemPortal> listItemPortal();

    ItemDetail getItemDetail(@Param("spuId")int spuId);
}
