package com.macro.ssm.mapper;

import com.macro.ssm.po.User;

import java.util.List;

/**
 * Created by zhenghong on 2017/9/21.
 */
public interface UserMapper {
    User findUserById(Integer id);

    void saveUser(User user);

    List<User> getUserList();
}
