package com.wsw.service;

import com.wsw.modle.User;

import java.util.List;

public interface UserService {

     List<User> getUserList();

     void deleteById(String userId);

     void addUer(User user);
}
