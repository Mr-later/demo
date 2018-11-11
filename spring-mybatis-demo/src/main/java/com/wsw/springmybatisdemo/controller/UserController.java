package com.wsw.springmybatisdemo.controller;

import com.github.pagehelper.PageInfo;
import com.wsw.springmybatisdemo.pojo.User;
import com.wsw.springmybatisdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
  public UserService userService;
@RequestMapping("/addUser")
    public List<User> addUser(User user){
        System.out.println("进入到添加方法");
        try{
            userService.addUser(user);
            return  userService.findAllUser();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("添加出现异常");
        }
        System.out.println("完成添加方法");
        return  null;
    }
 @RequestMapping("/findByPage")
    public PageInfo<User> findByPage(@RequestParam(name = "pageNum",defaultValue ="1") int
                                  pageNum , @RequestParam(name = "pageSize",defaultValue = "2") int pageSize){
        return userService.findUserByPage(pageNum,pageSize);

    }
}
