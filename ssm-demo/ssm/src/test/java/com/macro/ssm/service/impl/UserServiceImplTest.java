package com.macro.ssm.service.impl;

import com.macro.ssm.po.User;
import com.macro.ssm.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhenghong on 2017/9/21.
 */
public class UserServiceImplTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-trans.xml",
                "spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml");
    }

    @Test
    public void findUserById() throws Exception {
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = userService.findUserById(3);
        System.out.println(user.getUsername());
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setUsername("111");
        user.setPassword("111");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.saveUser(user);
    }

}