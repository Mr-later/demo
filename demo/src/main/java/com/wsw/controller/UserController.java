package com.wsw.controller;

import com.wsw.modle.User;
import com.wsw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Resource
    private UserService userService;
    @RequestMapping("/getAllUser")
    private List<User> getAllUser(Model model){
        System.out.println("-----controller-----");
        return userService.getUserList();
    }
    @RequestMapping("/deleteById")
    private List<User> deleteById(HttpServletRequest request){
        userService.deleteById(request.getParameter("userId"));
        return  userService.getUserList();
    }
    @RequestMapping("/addUser")
    private  List<User> addUser(User user){
        userService.addUer(user);
        return userService.getUserList();
    }

}
