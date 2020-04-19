package com.yelv.yelv_blog.service.impl;

import com.yelv.yelv_blog.entity.User;
import com.yelv.yelv_blog.mapper.UserRepository;
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
    UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        //MD5加密
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(pwd);
        User user = userRepository.findByUsernameAndPassword(username,pwd);
        return user;
    }
}
