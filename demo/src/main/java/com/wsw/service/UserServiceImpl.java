package com.wsw.service;



import com.wsw.dao.UserMapper;
import com.wsw.modle.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        System.out.println("=======UserserviceImpl");
        List<User> users = null;
        try {
            users = userMapper.selectAllUser();
            System.out.println(users.size());
           // System.out.println("users=" + JSON.toJSONString(users));
        } catch (Exception e) {
            System.out.println("chu cuo le");
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void deleteById(String userId) {
        System.out.println("deleteById:id=" + userId);
        userMapper.deleteByPrimaryKey(Integer.valueOf(userId));
    }

    @Override
    public void addUer(User user) {
//        System.out.println("add User:" + JSON.toJSONString(user));
        userMapper.insert(user);
    }
}
