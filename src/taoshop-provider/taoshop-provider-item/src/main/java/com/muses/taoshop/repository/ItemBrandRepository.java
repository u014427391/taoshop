package com.muses.taoshop.repository;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.vo.ItemBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MybatisRepository
public interface ItemBrandRepository {

    int deleteByPrimaryKey(Long id);

    int insert(ItemBrand record);

    int insertSelective(ItemBrand record);

    ItemBrand selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") ItemBrand record, @Param("example") ItemBrandExample example);

//    int updateByExample(@Param("record") ItemBrand record, @Param("example") ItemBrandExample example);

    int updateByPrimaryKeySelective(ItemBrand record);

    int updateByPrimaryKey(ItemBrand record);
}