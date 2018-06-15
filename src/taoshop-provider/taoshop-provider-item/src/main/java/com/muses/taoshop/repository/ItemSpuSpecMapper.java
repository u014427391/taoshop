package com.muses.taoshop.repository;

import com.muses.taoshop.common.core.database.annotation.MybatisRepository;
import com.muses.taoshop.vo.ItemSpuSpec;
import java.util.List;

import org.apache.ibatis.annotations.Param;

@MybatisRepository
public interface ItemSpuSpecMapper {


    int deleteByPrimaryKey(Long id);

    int insert(ItemSpuSpec record);

    int insertSelective(ItemSpuSpec record);

    List<ItemSpuSpec> selectByExample(ItemSpuSpec example);

    ItemSpuSpec selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemSpuSpec record, @Param("example") ItemSpuSpec example);

    int updateByExample(@Param("record") ItemSpuSpec record, @Param("example") ItemSpuSpec example);

    int updateByPrimaryKeySelective(ItemSpuSpec record);

    int updateByPrimaryKey(ItemSpuSpec record);
}