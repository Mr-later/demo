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
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/userController")
public class UserController {

    public static void main(String[] args) {
       // ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        // 参数：1、具体执行的任务   2、首次执行的延时时间
        //      3、任务执行间隔     4、间隔时间单位
//        service.scheduleAtFixedRate(
//                () -> System.out.println("执行任务A:" + LocalDateTime.now()),
//                0, 03, TimeUnit.SECONDS);
        String s="123456789";
        int[] ints = s.codePoints().toArray();
        System.out.println(Arrays.toString(ints));
        int[] ints1 = Arrays.copyOf(ints, 15);
        System.out.println(Arrays.toString(ints1));
    }
    @Resource
    private UserService userService;

    @RequestMapping("/getAllUser")
    private List<User> getAllUser(Model model) {
        System.out.println("-----controller-----");
        return userService.getUserList();
    }

    @RequestMapping("/deleteById")
    private List<User> deleteById(HttpServletRequest request) {
        userService.deleteById(request.getParameter("userId"));
        return userService.getUserList();
    }

    @RequestMapping("/addUser")
    private List<User> addUser(User user) {
        userService.addUer(user);
        return userService.getUserList();
    }

}
