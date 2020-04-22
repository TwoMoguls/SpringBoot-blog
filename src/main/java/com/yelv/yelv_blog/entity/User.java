package com.yelv.yelv_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String userNickName;
    private String userPass;
    private String userEmail;
    private String userAvatar;
    private Date userRegisterTime;
    private Date userLastLoginTime;
    private Integer userStatus;

}
