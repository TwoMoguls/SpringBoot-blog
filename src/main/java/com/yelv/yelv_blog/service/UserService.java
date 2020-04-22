package com.yelv.yelv_blog.service;


import com.yelv.yelv_blog.entity.User;

public interface UserService {
    public User checkUser(String userName, String userPass);
}
