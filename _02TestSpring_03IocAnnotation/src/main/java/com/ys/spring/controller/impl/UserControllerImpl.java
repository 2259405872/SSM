package com.ys.spring.controller.impl;

import com.ys.spring.controller.UserController;
import com.ys.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserControllerImpl implements UserController {
    private UserServiceImpl userService;

    public UserControllerImpl() {
    }


    @Autowired(required = false)
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String toString() {
        return "UserControllerImpl{" +
                "userService=" + userService +
                '}';
    }
}
