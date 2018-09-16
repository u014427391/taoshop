package com.muses.taoshop.item.mapper;


import com.muses.taoshop.item.entity.ItemDetail;
import com.muses.taoshop.item.entity.ItemPortal;
import com.muses.taoshop.item.entity.ItemSpec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<ItemPortal> listItemPortal();

    ItemDetail getItemDetail(@Param("spuId")int spuId);

}
