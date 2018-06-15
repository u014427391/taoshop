package com.muses.taoshop.repository;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.vo.ItemSkuSpecValue;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MybatisRepository
public interface ItemSkuSpecValueMapper {
    int countByExample(ItemSkuSpecValue example);

    int deleteByExample(ItemSkuSpecValue example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemSkuSpecValue record);

    int insertSelective(ItemSkuSpecValue record);

    List<ItemSkuSpecValue> selectByExample(ItemSkuSpecValue example);

    ItemSkuSpecValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemSkuSpecValue record, @Param("example") ItemSkuSpecValue example);

    int updateByExample(@Param("record") ItemSkuSpecValue record, @Param("example") ItemSkuSpecValue example);

    int updateByPrimaryKeySelective(ItemSkuSpecValue record);

    int updateByPrimaryKey(ItemSkuSpecValue record);
}