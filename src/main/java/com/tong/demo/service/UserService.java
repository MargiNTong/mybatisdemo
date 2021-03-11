package com.tong.demo.service;

import com.tong.demo.bean.ResultMessage;
import com.tong.demo.bean.User;
import com.tong.demo.mapper.UserMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMappers userMappers;

    private User user = new User();

    private ResultMessage resultMessage= ResultMessage.create();

    public Object userList(){
        List<User> users =this.userMappers.getUsers();
        if(!users.isEmpty()){
            resultMessage.raise(1,"SUCCESS");
            resultMessage.put("Result",users);
        }
        return resultMessage;
    }

}
