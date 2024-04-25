package com.sarahmark.kata_springboot.dao;

import com.sarahmark.kata_springboot.entity.User;

import java.util.List;


public interface UserDAO {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUser(long id);
    void deleteUser(long id);
}
