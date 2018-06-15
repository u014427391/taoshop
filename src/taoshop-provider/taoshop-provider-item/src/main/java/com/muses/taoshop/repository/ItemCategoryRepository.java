package com.muses.taoshop.repository;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.vo.ItemCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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