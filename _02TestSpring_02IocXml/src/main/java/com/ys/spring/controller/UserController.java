package com.ys.spring.controller;

import com.ys.spring.service.UserService;

public class UserController {
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void saveUser(){
        userService.saveUser();
    }

}
