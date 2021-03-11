package com.tong.demo.controller;

import com.tong.demo.bean.ResultMessage;
import com.tong.demo.bean.User;
import com.tong.demo.mapper.UserMappers;
import com.tong.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private UserMappers userMappers;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String sayHello(){
        return "Hello!";
    }
    @RequestMapping("/getUsers")
    public Object getUsers(){
        return userService.userList();
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Object addUser(@RequestParam(value="username") String username,
                          @RequestParam(value="userpass") String userpass,
                          @RequestParam(value="nickname") String nickname,
                          @RequestParam(value="gender") String gender){
        User user = new User();
        user.setUsername(username);
        user.setUserpass(userpass);
        user.setNickname(nickname);
        user.setGender(gender);
        this.userMappers.addUser(user);
        return userService.userList();

    }
}
