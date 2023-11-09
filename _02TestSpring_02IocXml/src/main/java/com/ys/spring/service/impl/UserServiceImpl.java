package com.ys.spring.service.impl;

import com.ys.spring.dao.UserDao;
import com.ys.spring.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
