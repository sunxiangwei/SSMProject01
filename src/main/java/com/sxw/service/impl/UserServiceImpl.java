package com.sxw.service.impl;

import com.sxw.dao.IUserDao;
import com.sxw.domain.User;
import com.sxw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sunxiangwei on 2020-5-1.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Override
    public boolean login(String uname, String upass) {
        return dao.login(uname,upass);
    }

    @Override
    public User findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void insertUsers(List<User> userList) {
        dao.insertUsers(userList);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
