package com.olimpio.taskmanager.controler;

import com.olimpio.taskmanager.domain.User;
import com.olimpio.taskmanager.service.LoginResponse;
import org.springframework.web.bind.annotation.*;
import com.olimpio.taskmanager.service.LoginService;

@RestController
@RequestMapping("/login")
public class loginController {

    private final LoginService loginService;

    public loginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping
    @CrossOrigin("http://localhost:5173")
    public LoginResponse loginAutenticator(@RequestBody User body){

        return loginService.validarLogin(body.getName(), body.getPasswd());
    }
}
