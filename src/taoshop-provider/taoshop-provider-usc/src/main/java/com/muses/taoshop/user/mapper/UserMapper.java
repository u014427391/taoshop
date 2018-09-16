package com.muses.taoshop.user.mapper;


import com.muses.taoshop.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User loginCheck(@Param("username") String username, @Param("password") String password);
}
