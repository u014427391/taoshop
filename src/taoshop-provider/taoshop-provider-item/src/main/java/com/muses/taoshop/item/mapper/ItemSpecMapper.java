package com.muses.taoshop.item.mapper;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.item.dto.ItemSpec;

@MybatisRepository
public interface ItemSpecMapper {
    int countByExample(ItemSpec example);


    int deleteByPrimaryKey(Long id);

    int insert(ItemSpec record);

    int insertSelective(ItemSpec record);

//    List<ItemSpec> selectByExample(ItemSpecExample example);

    ItemSpec selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") ItemSpec record, @Param("example") ItemSpecExample example);
//
//    int updateByExample(@Param("record") ItemSpec record, @Param("example") ItemSpecExample example);

    int updateByPrimaryKeySelective(ItemSpec record);

    int updateByPrimaryKey(ItemSpec record);
}