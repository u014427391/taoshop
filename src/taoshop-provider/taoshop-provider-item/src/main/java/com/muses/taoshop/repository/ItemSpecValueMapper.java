package com.muses.taoshop.repository;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.vo.ItemSpecValue;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MybatisRepository
public interface ItemSpecValueMapper {
//    int countByExample(ItemSpecValueExample example);
//
//    int deleteByExample(ItemSpecValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemSpecValue record);

    int insertSelective(ItemSpecValue record);

//    List<ItemSpecValue> selectByExample(ItemSpecValueExample example);

    ItemSpecValue selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") ItemSpecValue record, @Param("example") ItemSpecValueExample example);

//    int updateByExample(@Param("record") ItemSpecValue record, @Param("example") ItemSpecValueExample example);

    int updateByPrimaryKeySelective(ItemSpecValue record);

    int updateByPrimaryKey(ItemSpecValue record);
}