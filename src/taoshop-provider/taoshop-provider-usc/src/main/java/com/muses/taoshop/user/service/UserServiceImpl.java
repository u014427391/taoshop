package com.muses.taoshop.user.service;

import com.muses.taoshop.user.entity.User;
import com.muses.taoshop.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserMapper userMapper;

    /**
     * 登录验证
     *
     * @param username
     * @param password
     */
    @Override
    public User loginCheck(String username, String password) {
        return userMapper.loginCheck(username, password);
    }
}
