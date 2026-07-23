package com.olimpio.taskmanager.service;
import com.olimpio.taskmanager.Repositories.UserRepository;
import com.olimpio.taskmanager.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginService {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    ConsulteDatabase userConsute;
    private String token;

    private List<String> allUsers;

    private String password;

    public LoginResponse validarLogin(String nameBody, String passwdBody){
        boolean[] test = new boolean[2];
        allUsers = userConsute.getAllUsers();

        for(String user : allUsers){
            if (user.equals(nameBody)){
                test[0] = true;
                
                password = userConsute.getPassword(user);
                if(password.equals(passwdBody)){
                    test[1] = true;

                }
            }
            password = "";
        }

        LoginResponse status = new LoginResponse(token, test);
        return status;

    }
}
