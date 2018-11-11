package com.wsw.springmybatisdemo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsw.springmybatisdemo.dao.UserMapper;
import com.wsw.springmybatisdemo.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    public UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> findAllUser() {
        System.out.println("findAllUser==serviceImpl");
        return  userMapper.findAllUser();
    }

    @Override
    public PageInfo<User> findUserByPage(int pageNum, int pageSize) {
        System.out.println("findUserByPage==serviceImpl");
        PageHelper.startPage(pageNum,pageSize);
        try{
            PageInfo<User> userPageInfo = new PageInfo<>(userMapper.findAllUser());
            return userPageInfo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
