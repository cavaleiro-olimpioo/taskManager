package com.olimpio.taskmanager.service;

import com.olimpio.taskmanager.Repositories.UserRepository;
import com.olimpio.taskmanager.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ConsulteDatabase {
    private List<String> allUsers;
    private String password;

    private UserRepository userConsute;

    public ConsulteDatabase(UserRepository userConsute){
        this.userConsute = userConsute;
    }


    public List<String> getAllUsers() {
        allUsers = userConsute.findAllUsernames();
        return allUsers;
    }


}
