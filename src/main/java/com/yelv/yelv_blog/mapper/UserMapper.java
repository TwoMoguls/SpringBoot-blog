package com.yelv.yelv_blog.mapper;

import com.yelv.yelv_blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user WHERE user_name=#{userName} AND user_pass=#{userPass}")
    User findByUsernameAndPassword(String userName, String userPass);
}
