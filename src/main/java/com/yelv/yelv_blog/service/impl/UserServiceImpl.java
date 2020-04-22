package com.yelv.yelv_blog.service.impl;

import com.yelv.yelv_blog.entity.User;
import com.yelv.yelv_blog.mapper.UserMapper;
import com.yelv.yelv_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * 用户逻辑层
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String userName, String userPass) {
        //MD5加密
        String pwd = DigestUtils.md5DigestAsHex(userPass.getBytes());
        System.out.println(pwd);
        User user = userMapper.findByUsernameAndPassword(userName,pwd);
        System.out.println(user);
        return user;
    }
}
