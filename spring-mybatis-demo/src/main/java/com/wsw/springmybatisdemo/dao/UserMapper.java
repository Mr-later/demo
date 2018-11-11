package com.wsw.springmybatisdemo.dao;


import com.github.pagehelper.PageInfo;
import com.wsw.springmybatisdemo.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAllUser();
}