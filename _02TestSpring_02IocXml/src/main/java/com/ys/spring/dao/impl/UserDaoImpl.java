package com.ys.spring.dao.impl;

import com.ys.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存User");
    }
}
