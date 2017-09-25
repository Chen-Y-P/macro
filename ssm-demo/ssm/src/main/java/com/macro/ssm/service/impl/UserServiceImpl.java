package com.macro.ssm.service.impl;

import com.macro.ssm.mapper.UserMapper;
import com.macro.ssm.po.User;
import com.macro.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenghong on 2017/9/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
