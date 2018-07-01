package com.muses.taoshop.item.mapper;


import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.item.entity.ItemPortal;

import java.util.List;

@MybatisRepository
public interface ItemMapper {
    List<ItemPortal> listItemPortal();
}
