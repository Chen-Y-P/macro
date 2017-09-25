package com.macro.ssm.service;

import com.macro.ssm.po.User;

import java.util.List;

/**
 * Created by zhenghong on 2017/9/21.
 */
public interface UserService {
    User findUserById(Integer id);

    void saveUser(User user);

    List<User> getUserList();
}
