package com.wsw.springmybatisdemo.service;

import com.github.pagehelper.PageInfo;
import com.wsw.springmybatisdemo.pojo.User;

import java.util.List;

public interface UserService {
    int addUser (User user);
    List<User> findAllUser();
    PageInfo<User> findUserByPage(int pageNum,int pageSize);
}
