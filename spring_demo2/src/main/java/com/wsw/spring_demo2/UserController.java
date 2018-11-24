package com.wsw.spring_demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

       @Autowired
        private UserMapper userMapper;
       @RequestMapping("/addUser")
       public List<User> addUser(User user){
           System.out.println("进入addUser方法");
           userMapper.save(user);
           List<User> users = userMapper.findAll();
           System.out.println("查询条数是"+users.size());
           return users;
       }

    @RequestMapping("/editUser")
    public List<User> editUser(User user){
        System.out.println("进入editUser方法");
        userMapper.save(user);
        List<User> users = userMapper.findAll();
        System.out.println("查询条数是"+users.size());
        return users;
    }

    @RequestMapping("/countUser")
    public int countUser(User user){
        System.out.println("进入countUser方法");
        return userMapper.selectCount(user.getName());
    }
}
