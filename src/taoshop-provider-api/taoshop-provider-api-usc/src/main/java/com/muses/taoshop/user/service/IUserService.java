package com.muses.taoshop.user.service;


import com.muses.taoshop.user.entity.User;

public interface IUserService {
    /**
     * 登录验证
     * @param username
     * @param password
     */
    User loginCheck(String username, String password);
}
