package com.olimpio.taskmanager.service;
import com.olimpio.taskmanager.Repositories.UserRepository;
import com.olimpio.taskmanager.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    ConsulteDatabase userConsute;
    private String token;

    public LoginResponse validarLogin(String nameBody, String passwdBody){
        boolean[] test = new boolean[2];
        userConsute.getAllUsers();

        LoginResponse status = new LoginResponse(token, test);
        return status;

    }
}
