package com.sxw.service;

import com.sxw.domain.User;

import java.util.List;

public interface IUserService {
    boolean login(String uname, String upass);
    public User findById(Integer id);
    public void insertUsers(List<User> userList);

    List<User> findAll();
}
